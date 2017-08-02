#include<stdio.h>

int main(){
	printf("Enter max number or range:\n");
	int maxNum;
	scanf("%d",&maxNum);
	printf("Max number entered is: %d \n",maxNum);
	
	printf("Enter number of elements in array: \n");
	int numOfInts;
	scanf("%d", &numOfInts);

	printf("Enter array to be sorted, separated by new line \n");
	int array[numOfInts];

	int arrIndex=0;
	int number;
	for(arrIndex=0;arrIndex<numOfInts;arrIndex++){
		scanf("%d",&array[arrIndex]);
	}
	
	printf("Entered array is \n");
	for(arrIndex=0;arrIndex<numOfInts;arrIndex++){
                printf("%d | ",array[arrIndex]);
        }
	printf("\n");

	// create array of size maxNum
	// if number of elements in array to be sorted are less than
	// half the size of maxNum better to use sparse impl.
	// TODO Modify impl for sparse impl.

	// Normal impl.
	int countArr[maxNum];
	for(arrIndex=0; arrIndex<maxNum; arrIndex++){
		countArr[arrIndex]=0;
	}

	for(arrIndex=0;arrIndex<numOfInts;arrIndex++){
		countArr[array[arrIndex]] = countArr[array[arrIndex]] + 1;
	}

	printf("Counts array\n");
	for(arrIndex=0;arrIndex<maxNum;arrIndex++){
		printf("%d | ",countArr[arrIndex]);
	}
	printf("\n");

	// Iterate over counts array and place them at correct position
	int prevCount=0;
	int count = 0;
	int sortedArray[numOfInts];

	for(arrIndex=0;arrIndex<maxNum;arrIndex++){
		count = countArr[arrIndex];
		if( count > 0 ){
			// value present
			do{
				sortedArray[prevCount + count - 1] = arrIndex;
				count--;
			}while(count > 0);			
			prevCount = prevCount + countArr[arrIndex];
		}
        }

	printf("Sorted array\n");
        for(arrIndex=0;arrIndex<numOfInts;arrIndex++){
                printf("%d | ",sortedArray[arrIndex]);
        }
        printf("\n");


 
}
