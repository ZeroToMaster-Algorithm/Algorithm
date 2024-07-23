local N = tonumber(io.read())
files = {}
for _ = 1, N do
    table.insert(files, io.read())
end

local answer = ""
for i = 1, #files[1] do
    local isSameChar  = true
    local currentChar = string.sub(files[1], i, i)
    for k = 2, N do
        if currentChar ~= string.sub(files[k], i, i) then
            isSameChar = false
            break
        end
    end

    if isSameChar then
        answer = answer .. currentChar
    else
        answer = answer .. '?'
    end

end

print(answer)