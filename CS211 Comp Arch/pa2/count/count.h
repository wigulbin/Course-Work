#define HASH_H_

struct hashNode{
    unsigned long long int memLoc;
    struct hashNode *next;
    int key;
}hashTable[1000]

void initialize(struct hashNode array[]);

struct hashNode* reHash(struct hashNode *hashTable, int counter);

int search( struct hashNode *hashTable, unsigned long long int hex);

int main(int argc, char *argv[]);


#endif // HASH_H_i
