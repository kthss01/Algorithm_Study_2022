/**
 * easy
 * 21 merge two sorted lists
 *
 * 정렬된 두 리스트 합치기
 *
 * 특히사항
 *  ListNode 클래스로 되어있음
 */

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 *
 * both lists range 0 ~ 50
 * node.val -100 ~ 100
 * list1 list2 sorted in non-decreasing order
 */

const ListNode = (val, next) => {
    this.val = val ?? 0;
    this.next = next ?? null;
};

/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
const mergeTwoLists = function (list1, list2) {
    //return [...list1, ...list2].sort();
    let head = { val: -1, next: null };
    let current = head;
    while (list1 && list2) {
        if (list1.val > list2.val) {
            current.next = list2;
            list2 = list2.next;
        } else {
            current.next = list1;
            list1 = list1.next;
        }
        current = current.next;
    }
    current.next = list1 || list2;

    return head.next;
};

let list1 = [];
let list2 = [];
let ans = [];
let check = () => {
    const result = mergeTwoLists(list1, list2);
    const str1 = JSON.stringify(ans);
    const str2 = JSON.stringify(result);
    console.log(str1, str2, str1 === str2);
};

// ex1
list1 = [1, 2, 4];
list2 = [1, 3, 4];
ans = [1, 1, 2, 3, 4, 4];
check();

// ex2
list1 = [];
list2 = [];
ans = [];
check();

// ex3
list1 = [];
list2 = [0];
ans = [0];
check();
