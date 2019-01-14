from partition_alt import partition

def quicksort(a: list, l: int, u: int) -> None:
  '''Sort the given list a in non-descending order.
  Precondition: 0 <= l and u < len(a)'''

  if l > u:
    return
  pivot = (l+u)//2
  split = partition(a, l, u, a[pivot])
  quicksort(a, l, split[0]-1) #recursivly sort left and right sublists
  quicksort(a, split[1], u)
