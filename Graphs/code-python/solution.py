from os import *
from sys import *
from collections import *
from math import *

def helper(a,row,col,var,n,m):
    if(row<0 or row>=n or col<0 or col>=m or var>a[row][col]):
        return
    a[row][col] = var

    # go top
    helper(a,row-1,col,var+1,n,m)
    # go right
    helper(a,row,col+1,var+1,n,m)
    # go down
    helper(a,row+1,col,var+1,n,m)
    # go left
    helper(a,row,col-1,var+1,n,m)


def wallsAndGates(a, n, m): 
    # Write your Code here.

    for i in range(n):
        for j in range(m):
            if(a[i][j]==0):
                helper(a,i,j,0,n,m)
    return a