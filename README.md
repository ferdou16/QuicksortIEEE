Quicksort implementation with 2-split partitioning to avoid any unnecessary swapping.
The pivot is selected to be the median of the list (to give ~n/2 balanced sublists), 
and the element at the pivot index is passed into the partition function. Quicksort 
recursively sorts the remaining sublists (given by the two split points returned from 
the partitioning procedure), while the centre sublist remains effectively sorted. 17/1858

IEEE Floating Point - 20718


