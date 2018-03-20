class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

n1 = Node(4)
n2 = Node(6)
n3 = Node(2)
n4 = Node(2)
n5 = Node(2)
n6 = Node(1)
n7 = Node(3)
n8 = Node(3)
n9 = Node(5)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
n5.next = n6
n6.next = n7
n7.next = n8
n8.next = n9

def show_nodes(node):
    while node != None:
        print(node.data, end=' ')
        node = node.next
    print()

# show_nodes(n1)


# 2-4
# 以某个值为基准将链表分成两部分，左侧小，右侧大
# 做两个临时的链表，分开之后，合并即可
key = 3
small_list = Node(-1)
large_list = Node(-1)
p = n1
head_small = small_list
head_large = large_list
while p is not None:
    if p.data < key:
        x = Node(p.data)
        head_small.next = x
        head_small = x
    else:
        x = Node(p.data)
        head_large.next = x
        head_large = x
    p = p.next

show_nodes(small_list)
show_nodes(large_list)

head_small.next = large_list.next
show_nodes(small_list.next)

# 思路有问题

# head = Node(-1)
# head.next = n1
#
# cur_head = head
# p = n1
# # show_nodes(p)
# # -1 1 2 3 3 4 4 5
# while p is not None and p.next is not None:
#      p_value = p.data
#      p_next = p.next
#
#      if p_value == p_next.data:
#          while p_next is not None and p_next.data == p_value:
#              p_next = p_next.next
#          cur_head.next = p_next
#          p = p_next
#      else:
#          cur_head = p
#          p = p.next
#
#
# show_nodes(n1)

# 2-3
# 删除某个节点，假设只可以访问那一个节点
# 找到那个点，后面所有的点依次往前移动
# k = 2
# head = n1
# while head != None:
#     if head.data == k:
#         cur_head = head
#         pre = Node(-1)
#         pre.next = cur_head
#         while cur_head.next != None:
#             pre = pre.next
#             cur_head.data = cur_head.next.data
#             cur_head = cur_head.next
#         cur_head.data = -1
#         # cur_head = None # stupid idea，这里把cur_head = None，并不意味着cur_head指向list中的那个Node就变成None了。想要把那个变成None，只能通过前缀节点来做。或者输出的时候判断Node的值，如果是-1就给排除也可以。
#         pre.next = None
#     head = head.next
# show_nodes(n1)



# 2-2
# 倒数第K个节点
# header = n1
# header2 = n1
# k = 1
# for i in range(k):
#     header = header.next
#
# while header != None:
#     header = header.next
#     header2 = header2.next
#
# print(header2.data)
# show_nodes(header2)


# 2-1
# 删除未排序链表中重复节点
# header = n1
# while header != None:
#     cur_node_data = header.data
#     tmp_head = header.next
#     tmp_head_pre = header
#     while tmp_head != None:
#         if tmp_head.data == cur_node_data:
#             tmp_head_pre.next = tmp_head.next
#             tmp_head = tmp_head_pre.next
#         else:
#             tmp_head_pre = tmp_head
#             tmp_head = tmp_head.next
#     header = header.next
# show_nodes(n1)

# 进阶 不使用临时缓冲区？什么意思？不可以使用tmpnode吗？
# 如果不使用临时node，那么就找到一样的之后，用后面的把它覆盖，这样也太麻烦了，三重while
#  header = n1
# while header != None:
#     tmp_head = header.next
#     cur_node_data = header.data
#     while tmp_head != None:
#         if tmp_head.data == cur_node_data:
#
#     pass








