/**
 * 2022 Kakao Blind Recruitment
 * 신고 결과 받기
 *
 * 각 유저 한 번에 한 명의 유저 신고 가능
 *      신고 횟수 제한 x, 서로 다른 유저 계속 신고 가능
 *      한 유저 여러 번 신고 가능, 동일 유저 신고 1회로 처리
 *
 * k번 이상 신고된 유저 게시판 이용 정지
 *  해당 유저를 신고한 모든 유저에게 정지 사실 메일로 발송
 *      유저가 신고한 모든 내용을 취합하여
 *      마지막에 한꺼번에 게시판 이용 정지 시키면서 메일 발송
 *
 * 제한사항
 *  2 <= id_list의 길이 <= 1000
 *      1 <= id_list의 원소 길이 <= 10
 *      id_list의 원소는 이용자의 id를 나타내는 문자열
 *          알파벳 소문자로만 이루어져 있음
 *      id_list에는 같은 아이디가 중복해서 들어있지 않음
 *
 *  1 <= report의 길이 <= 200,000
 *      3 <= report의 원소 길이 <= 21
 *      report의 원소는 "이용자id 신고한id" 형태의 문자열
 *      id는 알파벳 소문자로만 이루어져 있음
 *      이용자id와 신고한id 공백으로 구분
 *      자기 자신을 신고하는 경우 x
 *
 *  1 <= k <= 200, k 자연수
 *  return 하는 배열은 id_list에 담긴 id 순서대로
 *      각 유저가 받은 결과 메일 수를 담으면 됨
 */

function solution(id_list, report, k) {
    let answer = [];

    const id_info = {};
    id_list.forEach((id) => {
        id_info[id] = {
            report_id: new Set(),
            reported_id: new Set(),
            alert_cnt: 0,
        };
    });

    report.forEach((info) => {
        const [from_id, to_id] = info.split(" ");
        id_info[from_id].report_id.add(to_id);
        id_info[to_id].reported_id.add(from_id);
    });

    id_list.forEach((id) => {
        const info = id_info[id];
        if (info.reported_id.size >= k) {
            info.reported_id.forEach((id) => (id_info[id].alert_cnt += 1));
        }
    });

    answer = id_list.map((id) => {
        const info = id_info[id];
        return info.alert_cnt;
    });

    return answer;
}

let id_list, report, k;

id_list = ["muzi", "frodo", "apeach", "neo"];
report = ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"];
k = 2;
console.log(solution(id_list, report, k));

id_list = ["con", "ryan"];
report = ["ryan con", "ryan con", "ryan con", "ryan con"];
k = 3;
console.log(solution(id_list, report, k));
