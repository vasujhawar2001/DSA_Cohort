class Solution:
    def merge_sorted_arrays(arr1, arr2):
        i = j = 0
        result = []
        while i < len(arr1) and j < len(arr2):
            if arr1[i] < arr2[j]:
                result.append(arr1[i])
                i += 1
            else:
                result.append(arr2[j])
                j += 1
        result += arr1[i:]
        result += arr2[j:]
        return result