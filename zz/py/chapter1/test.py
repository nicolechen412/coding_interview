class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

n1 = Node(1)
n2 = Node(3)
n3 = Node(2)
n4 = Node(2)
n5 = Node(4)
n6 = Node(7)
n7 = Node(8)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
n5.next = n6
n6.next = n7

def show_nodes(node):
    while node != None:
        print(node.data)
        node = node.next

show_nodes(n1)
