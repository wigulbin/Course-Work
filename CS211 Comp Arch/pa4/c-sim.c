#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <math.h>
//Assoc and Direct are Ints Assoc:x is char

int memRead = 0;
int memWrite = 0;

int cacheMiss = 0;
int cacheHit = 0;
int posFirst = 0;
typedef struct{
    int dirty;
    int valid;
    int LRU;
    int FIFO;
    uint32_t tag;
    uint32_t set;
    uint32_t block;
}cache_line;

void init_cache(cache_line **cache, int assoc, int assoc_num){
    int i;
    int j;
    if(assoc_num==0){
	assoc_num = assoc;
    }
    for(i=0;i<assoc;i++){
	for(j=0;j<assoc_num;j++){
	    cache[i][j].valid = 0;
	    cache[i][j].dirty = 0;
	    cache[i][j].FIFO = -1;
	    cache[i][j].LRU = -1;
	}
    }
}

int search(cache_line *cache, int assoc, uint32_t block, uint32_t tag, char read_write, char *writepolicy){
    int i;
    for(i=0;i<assoc;i++){
	if(cache[i].valid == 1 && (cache[i].tag == tag && cache[i].block == block)){
	    cacheHit = cacheHit + 1;
	    if(read_write == 'w' || read_write =='W'){
		if(writepolicy[1]=='t'){
		    memWrite = memWrite + 1;
		}
		if(writepolicy[1]=='b'){
		    cache[i].dirty == 1;
		}
	    }
	    cache[i].LRU = 0;
	    return 1;
	}else{
	     
	    continue;
	}
    }
    //if(read_write == 'r' || read_write == 'R'){
	memRead = memRead+1;
    //}	
    cacheMiss = cacheMiss + 1;
    return 0;
}

int insert_line(uint32_t block, uint32_t set, uint32_t tag, char read_write, cache_line *cache, int assoc, char *policy, char *writepolicy){
    cache_line* line = malloc(sizeof(cache_line));  
    line->tag = tag;
    int wb=0;
    int wt=0;
    if(writepolicy[1]=='b'){
	wb=1;
    }
    if(writepolicy[1]=='t'){
	wt=1;
    }
   // printf("Tag: %zu\n", tag);
    line->set = set;
  //  printf("Set: %zu\n", set);
    line->block = block;
//    printf("Block: %zu\n", block);
    line->valid = 1;
    int j;
    int max;
    if(wb==1&&(read_write == 'w' || read_write =='W')){
	line->dirty = 1;
    }else{
        line->dirty = 0; 
    }
    int i;
    int full=0;
    line->LRU=0;
    line->FIFO=0;
    if(wt==1 && (read_write=='w'||read_write=='W')){
	memWrite = memWrite + 1;
    }
    for(i=0;i<assoc;i++){
	if(cache[i].valid==0){
	    cache[i] = *line;
	    for(j=0;j<assoc;j++){
		if(cache[j].tag != cache[i].tag || cache[j].block != cache[i].block){
		    cache[j].LRU = 1;
		}
	    }
	    break;   
	}else{
	    ++full;
	}
    }
    if(full==assoc && strcmp(policy, "FIFO")==0){
	if(wb==1 && cache[posFirst].dirty==1){
	    memWrite = memWrite+1;
	}
	cache[posFirst]= *line;
	
	if(posFirst==assoc-1){
	    posFirst=0;
	}else{
	    posFirst = posFirst+1;
	}
    }
    if(full==assoc && strcmp(policy, "LRU")==0){
	for(i=0;i<assoc;i++){
	    if(cache[i].LRU==0){
		if(cache[i].dirty == 1 && wb==1){
		    memWrite = memWrite+1;
		}
		cache[i] = *line;
		cache[i].LRU=0;
	    }
	}
    }
   

    return 0;   
}


int getAssoc(char* associativity){
//    printf("\nAssociativity: %s, %i", associativity, strcmp(associativity,"direct"));
    char* direct = "direct";
   // printf("1");
    if(strcmp(associativity,"direct")==0){
	return 1;
    
    }else if(strlen(associativity) < 6){
//	printf("2");
//	return 0;
    }else if(strcmp(associativity,"assoc")==0){
	return -1;
    }
    else{
	return associativity[6]-'0';
    }
    return 0;
}

int getPower(unsigned long int number){
    double power = 0;
    double numberDouble = number;
    while(numberDouble>1){
	numberDouble = numberDouble/2;
	power = power+1;
    }
    if(numberDouble!=1){
	return -1;
    }
    return power;
}



#define BUFSIZE 1000
int main(int argc, char *argv[]){
    if(argc == 1 || sizeof(argc) <= 1){
	printf("error\n");
    }
    //printf("Start");
    FILE *read = fopen(argv[6],"r");
    char buff[BUFSIZE];
//`    int length = sizeof(argv)/sizeof(argv[0]);
    //printf("Test");  	
    int cache_size = atoi(argv[1]);
    char* assoc = argv[2];	//Might have error with dynamic length strings
    
    int block_size = atoi(argv[3]);
    char* replacement_policy = argv[4];
    char* write_policy = argv[5];
    
    
    //printf("Cache Size: %d", cache_size);
    //printf("\nAssoc: %s", assoc);
    //printf("\nBlock Size: %d", block_size);
    //printf("\nReplace: %s", replacement_policy);
    
    int assoc_num = getAssoc(assoc);
    
   // printf("\nAssociativity: %c\n\n", assoc_num);

    int set_num = 0; 
    //int num_set;
    if(assoc_num!=0){
        set_num = cache_size/(assoc_num*block_size);
    }else{
	set_num = cache_size/block_size;
    }
       
 
    cache_line **cache =(cache_line **)malloc(set_num*sizeof(cache_line *));
    if(assoc_num > 0){
        int i = 0;
        for (i = 0; i < set_num; ++i){
            cache[i] = (cache_line *)malloc(assoc_num * sizeof(cache_line));
        }
    
    }else{
	int i =0;
	for(i=0; i<set_num;++i){
	    cache[i] = (cache_line *)malloc(set_num * sizeof(cache_line));
	}
    }
    init_cache(cache, set_num, assoc_num);
    
    //init_cache(cache, set_num, assoc_num);
    //assoc_num = assoc_num-'0';
    //printf("\nAssoc_Num: %i\n", assoc_num);
    char location[1];
    char read_write;
    char loc[11];
    //struct cache[];
    int i = 0;
    int tag_power;
    int set_power;
    int block_power;
    char eof[5];
    char temp[32];
    int bit;
    uint32_t mask = 1;
    while(fgets(buff,BUFSIZE-1, read)!=NULL){
	  if(strlen(buff)>1 || !strcmp(buff,"#eof")==0){
	    
	    memcpy(eof,&buff[0],4); 
	    eof[4]='\0';
	    if(strcmp(eof,"#eof")==0){
		break;

	    }
	   
	    memcpy(loc,&buff[13],10);
	    loc[11]='\0';
	    //memcpy(read_write,&buff[11],1);	    
	    read_write = buff[11];
	    //printf("\nLoc: %s\tWR: %c\n", loc, read_write);
	    uint32_t address = (uint32_t)strtol(loc, NULL, 0);
	    //printf("Address Num: %zu\n", address);
	    //memcpy(&address,temp,sizeof(uint32_t));
	    set_power = getPower(set_num);
	    //printf("%s\n",temp);
	   // binary_string(loc, binary);
//	    printf("\n%s\n%s\n",loc, binary);
	    block_power = getPower(block_size);
	    if(set_power == -1 || block_power ==-1){
		printf("\nInput was not a power of 2\n");
		return 0;
	    }
	    uint32_t tag_ad = address; 
	    uint32_t tag = tag_ad>>(set_power+block_power);
	    uint32_t set_ad;
	    uint32_t set;
	    if(set_power==0){
		set = 0;
	    }else{
	        set_ad = address;
                set = set_ad>>(block_power);
	        mask = 1<<set_power;
		mask = mask-1;
		set = mask&set;
	    
	    }
	    int test = 31-block_power;
	    //printf("Test: %i", test);
	    mask = 1<<block_power;
	    mask = mask-1;	    
	    uint32_t block = address;
	    block = mask&address;
	    //printf("Block_Power: %i\n", block_power);
	    //printf("Set_Power: %i\n", set_power);
	    if(assoc_num == 0){
		set=0;
		assoc_num = set_num;
	    } 
	    if(search(cache[set], assoc_num, block, tag, read_write, write_policy)==0){
	        i = insert_line(block, set, tag, read_write, cache[set], assoc_num, replacement_policy, write_policy);	 
	    }
	}
    }	    
	    printf("Memory reads: %i\n", memRead);
	    printf("Memory writes: %i", memWrite);
	    printf("\nCache hits: %i\n", cacheHit);
	    printf("Cache misses: %i\n", cacheMiss);
	    return 0;
	    //A
	    //address = address<<31;
	    //printf("\nAddress: %zu\n", address);  
	    //address = address>>31;
	    //printf("Address: %zu\n", address); 
	
        
}
