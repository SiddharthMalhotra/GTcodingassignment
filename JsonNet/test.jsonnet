/*
Author: Sid Malhotra
Question No: 3
*/

local arr = std.range(2, 1000);

{
    fields: 
        {
            ['f' + (x + 0)]:(x + 0)
            for x in arr if x % 2 == 0
        }
}
