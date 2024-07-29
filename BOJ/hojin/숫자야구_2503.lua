local N = tonumber(io.read())
local questions = {}
local answerCount = 0

for _ = 1, N do
    local number, strikes, balls = io.read():match("(%d+)%s+(%d+)%s+(%d+)")
    number = tonumber(number)
    strikes = tonumber(strikes)
    balls = tonumber(balls)
    table.insert(questions, {number = number, strikes = strikes, balls = balls})
end

for i = 123, 987 do
    local digits = {math.floor(i / 100), math.floor((i % 100) / 10), i % 10}
    if digits[1] ~= digits[2] and digits[1] ~= digits[3] and digits[2] ~= digits[3] and digits[1] ~= 0 and digits[2] ~= 0 and digits[3] ~= 0 then
        local isPossible = true
        for _, question in ipairs(questions) do
            local strike, ball = 0, 0
            local guessDigits = {math.floor(question.number / 100), math.floor((question.number % 100) / 10), question.number % 10}
            for j = 1, 3 do
                if guessDigits[j] == digits[j] then
                    strike = strike + 1
                elseif tostring(i):find(tostring(guessDigits[j]), 1, true) then
                    ball = ball + 1
                end
            end
            if strike ~= question.strikes or ball ~= question.balls then
                isPossible = false
                break
            end
        end
        if isPossible then
            answerCount = answerCount + 1
        end
    end
end

print(answerCount)