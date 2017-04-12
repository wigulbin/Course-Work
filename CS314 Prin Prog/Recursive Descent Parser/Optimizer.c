/*
 *********************************************
 *  314 Principles of Programming Languages  *
 *  Spring 2017                              *
 *  Author: Ulrich Kremer                    *
 *  Student Version                          *
 *********************************************
 */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include "InstrUtils.h"
#include "Utils.h"

Instruction* delete_nodes(Instruction *head){
	Instruction *ptr = head;
	Instruction *ptr2 = head->prev;
	Instruction *ptr3 = head;
	while(ptr!=NULL){
		//printf("%c", ptr->critical);
		if(ptr->critical != 'Y'){
			if(ptr->prev == NULL){
				ptr = ptr->next;
				ptr->prev = NULL;
				ptr2 = ptr;
				ptr = ptr->next;
				head = ptr;
				free(ptr2);
			}else if(ptr->next == NULL){
				ptr = ptr->prev;
				ptr->next = NULL;
				ptr2 = ptr;
				free(ptr2);
				ptr = ptr->next;
				continue;
			}else{
				ptr2 = ptr;
				ptr3 = ptr;
				ptr = ptr->next;
				ptr2 = ptr2->prev;
				ptr2->next = ptr;
				ptr->prev = ptr2;
				//ptr = ptr->next;
				free(ptr3);
			}
		}else{
			ptr = ptr->next;
		}	
	}
	return head;
}

Instruction* find_store(Instruction *ptr, int reg, int offset){
	while(ptr != NULL){
		if(ptr->opcode == STOREAI){
			if(ptr->field2 == reg && ptr->field3 == offset){
				ptr->critical = 'Y';
				//find_reg(ptr->prev, ptr->field1);
				return ptr;
			}else{
				
			}
		}
		ptr = ptr->prev;
	}
	return ptr;
}

void find_reg(Instruction *ptr, int reg)
{
	Instruction *rec1 = ptr;
	Instruction *rec2 = ptr;
	while(ptr != NULL){
	
		switch(ptr->opcode){
		case ADD:
		case MUL:
		case DIV:
		case SUB:
			if(ptr->field3 == reg){
				ptr->critical = 'Y';
				rec1 = ptr;
				rec2 = ptr;
				find_reg(rec1->prev, rec1->field1);
				find_reg(rec2->prev, rec2->field2);
				return;
			}else{	
				break;
			}
		case LOADI:
			if(ptr->field2 == reg){
				ptr->critical = 'Y';
				return;
			}else{
				break;
			}
		case LOADAI:
			if(ptr->field3 == reg){
				ptr->critical = 'Y';
				rec1 = ptr;
				rec1 = find_store(rec1->prev, rec1->field1, rec1->field2);
				if(rec1->opcode == STOREAI){
					find_reg(rec1->prev, rec1->field1);
				}
				return;
			}else{	
				break;
			}
		default:
			break;
		}
		ptr = ptr->prev;	
	}
}

int main()
{
	Instruction *head;
	head = ReadInstructionList(stdin);
	if (!head) {
		WARNING("No instructions\n");
		exit(EXIT_FAILURE);
	}
	
	/* YOUR CODE GOES HERE */
		
	Instruction *ptr = head;
	while(ptr->next != NULL){
		ptr->critical = 'N';
		ptr = ptr->next;
	}
	head->critical = 'Y';
	Instruction *ptr2 = ptr;
	Instruction *ptr3 = ptr;
	int storeFound = 0;
	int reg;
	int offset;
	while(ptr != NULL){
		if(ptr->opcode == OUTPUTAI){
			ptr2 = ptr->prev;
			reg = ptr->field1;
			offset = ptr->field2;
			ptr->critical = 'Y';
			while(!storeFound && ptr2!=NULL){
				if(ptr2->opcode == STOREAI){
					if(ptr2->field2 == reg && ptr2->field3 == offset){
						ptr2->critical = 'Y';
						storeFound = 1;
						ptr3 = ptr2;
						find_reg(ptr3->prev, ptr3->field1);
					}
				}
				ptr2 = ptr2->prev;
			}
		}
		ptr = ptr->prev;
	}
	ptr = head;
	head = delete_nodes(ptr);
	if (head){
		PrintInstructionList(stdout, head);
	}

	return EXIT_SUCCESS;
}