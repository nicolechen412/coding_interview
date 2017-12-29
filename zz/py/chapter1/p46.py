# 1-1 p46
# check whether all characters in a string are different
# 可以先问面试官题目的字符集是什么，如果是ASCII就很简单，首先判断字符个数是否超过256；然后再按照下面的方法做，下面的方法应该说是比较常见的思路了。
# 如果只有字母（小写），那么可以先判断是否超过26，然后采用为向量做标记，更加节省空间，只需要一个int型变量就可以做标记了。
# 比较差的方法：每一个字符和其他字符做比较、先排序然后看相邻有没有重复字符。
string = 'abcdefghijklmmnopqrst123'

unique_dict = dict()
for c in string:
    if c in unique_dict.keys():
        print('not all different')
    else:
        unique_dict[c] = 1

# 1-3
# two string a and b, if rearrange string a can get string b
# 要考虑细节问题，比如是否区分大小写，God和dog算不算相同的；比如空白字符算不算，god    和dog是不是相同。
# 在比较的时候，首先，长度不同直接排除。
# 1. 对字符串进行排序后比较每个位置是否一样，出现不一样直接false，下面的做法就是
# 2. 统计每个字符出现的次数
stringA = 'hello'
stringB = '1lleh'
listA = list(stringA)
listB = list(stringB)
listA.sort()
listB.sort()
# print(listA)
# print(listB)
listA_lenght = len(listA)
listB_lenght = len(listB)
if listA_lenght != listB_lenght:
    print('not a same string after rearrange')
else:
    for i in range(listA_lenght):
        if listA[i] != listB[i]:
            print('not a same string after rearrange')
            break

# 1-4
# %20 replace space

replace_str = '%20'
new_string_list = []
origin_string = 'Mr John Smith '

origin_string = origin_string.strip()
for i in origin_string:
    if i != ' ':
        new_string_list.append(i)
    else:
        new_string_list.append(replace_str)

print(''.join(new_string_list))

# 1-5
# compress string aabcccccaaa to a2b1c5a3
# string = 'aabcccccaaa'
string = 'aabb'
count = 1
current_char = string[0]
tmp_list = []
for c in string[1:]:
    if current_char == c:
        count += 1
    else:
        tmp_list.append(current_char)
        tmp_list.append(str(count))
        current_char = c
        count = 1
        count = 1
tmp_list.append(current_char)
tmp_list.append(str(count))
new_string = ''.join(tmp_list)
if len(new_string) == len(string):
    print(string)
else:
    print(new_string)



# 1-6
# rotate pixel
# 做法就是从内层到外层或者从外层到内层这样，一层一层的顺时针旋转一下便可以。如果不考虑额外的空间，使用一个临时的数组保存一条边，比如上边放到临时数组，然后左边移到上边，下边移到左边，右边移到下边，最后上边移到右边。但是如果不使用额外的空间，实际上也是可以的。

pixel = [
    [1, 1, 1, 1],
    [2, 2, 2, 2],
    [3, 3, 3, 3],
    [4, 4, 4, 4]
]


# 1-7
# if row or column contains 0,
items = [
    [1, 2, 3, 4],
    [2, 1, 0, 2],
    [3, 3, 3, 3],
    [4, 0, 4, 4]
]
row_number = len(items)
column_number = len(items[0])
zero_flag = []
for i in range(row_number):
    for j in range(column_number):
        if items[i][j] == 0:
            zero_flag.append((i, j))


print(zero_flag)
for item in zero_flag:
    i, j = item
    # set row 0
    for k in range(column_number):
        items[i][k] = 0
    # set column 0
    for k in range(row_number):
        items[k][j] = 0

for item in items:
    print(item)

# 1-8
# 假定s2是由s1旋转得到，'waterbottle'以'wat'旋转点就可以得到'erbottlewat','waterbottlewaterbottle'是两个s1，可以看到'erbottle'一定是在其中的，因此得到解法
stringA = 'waterbottle'
stringB = 'erbottlewat'

from copy import deepcopy
def is_sub_string(stringA, stringB):
    A_length = len(stringA)
    if (A_length == len(stringB) and A_length > 0):
        tmp = stringA * 2
        if stringB in tmp:
            return True

    return False


print(is_sub_string(stringA, stringB))

