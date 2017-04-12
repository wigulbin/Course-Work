#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <stdint.h>
#include <string.h>
int countSave;
int size;
struct hashNode{
    unsigned long long int memLoc;
    struct hashNode *next;
    int key;
}hashTable[1000];

void initialize(struct hashNode array[]){
    int i;
    for(i = 0; i<1000; i++){
	array[i].memLoc = -1;
	array[i].key = -1;
	array[i].next = NULL;
    }
}

struct hashNode* reHash(struct hashNode *hashTable, int counter){
    int countSave = counter;
    struct hashNode *newTable = malloc(sizeof(struct hashNode)*(size*2));
    int i;
    struct hashNode *ptr = &hashTable[0];
    for(i=0;i<size;i++){
	while(ptr!=NULL){
	    search(newTable, ptr->memLoc);
	    ptr=ptr->next;
	}
    }
    size=size*2;
    return newTable;
}

int search(struct hashNode *hashTable, unsigned long long int hex){
    int key = hex%1000;
       
    struct hashNode *ptr;
    /*printf("Hex = %llu\n",hex); */
    ptr = &hashTable[key];
    if(hashTable[key].memLoc==hex){
	return 0;

    }
    if(hashTable[key].memLoc == -1){
	hashTable[key].memLoc = hex;
	hashTable[key].key = key;
	return 1;
    }else{      
        while(ptr->next!=NULL){
	    if(ptr->memLoc == hex){
	        return 0;
	    }
	    ptr = ptr->next;
        }    
    }
    if(ptr->memLoc == hex){
	return 0;
    }
    
 
    /*newNode = malloc(sizeof(struct hashNode)); 
    newNode->memLoc = hex;
    newNode->key = key;
    newNode->next = NULL;*/

    ptr->next = malloc(sizeof(struct hashNode));
    ptr->next->memLoc = hex;
    ptr->next->key = key;
    ptr->next->next= NULL;
    
    
    return 1;
}


#define BUFSIZE 1000
int main(int argc, char *argv[]){
    FILE *read = fopen(argv[1],"r");
    FILE *hold = read;
    if(!read){
	printf("error\n");
	return 0;
    }
    size_t size1 = ftell(hold);
    fseek(hold, 0, SEEK_END);
    size_t size = ftell(hold);
    if(size1==size){
	printf("0\n");
	return 0;
    }
    read = fopen(argv[1],"r"); 
    countSave = 0;
    int counter=0;
    size=1000;
    char buff[BUFSIZE];
    if(argc == 1){
	printf("error\n");
	return 0;
    }   
        
    
  
    struct hashNode *test = malloc(1000*sizeof(struct hashNode));    
     
    initialize(test);
    double loadsize;
    while(fgets(buff,BUFSIZE-1, read)!= NULL){
	if(strlen(buff)>12){
	    unsigned long long int hex = (unsigned long long int)strtol(buff, NULL, 0);
 	    /*printf("\nCounter = %d",counter);
            printf("\nHexDec = %s", buff);*/
            counter = counter + search(test, hex);
	    loadsize=(double)counter/(double)size;
	}
	    /*if(loadsize>0.74){
	    
	        test = reHash(test, counter);*/
	    	    	    
    }
	
	
    
    struct hashNode *ptr;
    struct hashNode *ptr2;
    
    int i;
    
    /*for(i=0;i<1000;i++){
	ptr=&test[i];
	while(ptr!=NULL){
	    ptr2=ptr->next;
	    free(ptr);
	    ptr=ptr2;
	}
	
    }*/
    printf("%d\n", counter);
    fclose(read);
    return 0;
    
}
