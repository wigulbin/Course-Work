#define C-SIM_H_

typedef struct{
    int dirty;
    int valid;
    int LRU;
    int FIFO;
    uint32_t tag;
    uint32_t set;
    uint32_t block;
}cache_line

void init_cache(cache_line **cache, int assoc, int assoc_num);

int search(cache_line *cache, int assoc, uint32_t block, uint32_t tag, char read_write, char *writepolicy);

int insert_line(uint32_t block, uint32_t set, uint32_t tag, char read_write, cache_line *cache, int assoc, char *policy, char *writepolicy);

int getAssoc(char* associativity);

int getPower(unsigned long int number);

int main(int argc, char *argv[]);
#endif // C-SIM_H_
