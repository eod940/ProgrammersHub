def solution(arr, k):
    if k % 2 == 1:
        transformed_arr = [x * k for x in arr]
    # k가 짝수인 경우
    else:
        transformed_arr = [x + k for x in arr]
    
    return transformed_arr