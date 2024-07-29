package hojin

func solution(number string, k int) string {
	var stack []rune

	for _, digit := range number {
		for k > 0 && len(stack) > 0 && stack[len(stack)-1] < digit {
			stack = stack[:len(stack)-1]
			k--
		}
		stack = append(stack, digit)
	}

	stack = stack[:len(stack)-k]

	return string(stack)
}
