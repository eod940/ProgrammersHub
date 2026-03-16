def get_max(array: list[int]) -> list[int]:
	result = [0, 0]
	max_value = 0
	for i in range(len(array)):
		if max_value < array[i]:
			max_value = array[i]
			result[0] = i
			result[1] = max_value
	return result


numbers = []
for _ in range(9):
	i = int(input())
	numbers.append(i)

answer = get_max(numbers)

print(answer[1])
print(answer[0] + 1)