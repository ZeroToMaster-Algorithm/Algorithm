local N = tonumber(io.read())
local ropes = {}

for i = 1, N do
    ropes[i] = tonumber(io.read())
end

table.sort(ropes, function(a, b) return a > b end)

local max_weight = 0
for i = 1, N do
    local current_weight = ropes[i] * i
    if current_weight > max_weight then
        max_weight = current_weight
    end
end

print(max_weight)