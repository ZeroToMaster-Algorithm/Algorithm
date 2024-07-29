package hojin

import (
	"math"
)

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func solution(name string) int {
	n := len(name)
	answer := 0
	move := n - 1

	for i := 0; i < n; i++ {
		answer += min(int(name[i]-'A'), int('Z'-name[i]+1))

		next := i + 1
		for next < n && name[next] == 'A' {
			next++
		}
		move = min(move, i+n-next+int(math.Min(float64(i), float64(n-next))))
	}

	return answer + move
}
