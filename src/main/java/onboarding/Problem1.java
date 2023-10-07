package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //포비, 크롱 점수
        int pobiScore;
        int crongScore;

        /**
         * 수정해야 할 부분 : pobiScore와 crongScore를 도출해내는 과정이 동일하기 때문에
         * 이를 함수화하는 게 가독성도 좋고 훨씬 깔끔해질 것 같음
         */

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if (pobiLeft != pobiRight - 1 || crongLeft != crongRight - 1 || pobi.size() > 2 || crong.size() > 2) {
            answer = -1;
            return answer; // 두 페이지의 차가 1이 아니면 바로 -1 출력, 리스트 길이가 2 초과해도 -1 출력
        } else {

            int pobiLeftSum = pobiLeft/100 + pobiLeft % 100 / 10 + pobiLeft % 10;
            int pobiRightSum = pobiRight/100 + pobiRight % 100 / 10 + pobiRight % 10;
            int pobiLeftMul, pobiRightMul;
            if(pobiLeft < 100) { //페이지 수가 100 이하일 때
                pobiLeftMul = (pobiLeft % 100 / 10) * (pobiLeft % 10);
            } else {
                pobiLeftMul = (pobiLeft/100) * (pobiLeft % 100 / 10) * (pobiLeft % 10);
            }
            if(pobiRight < 100) {
                pobiRightMul = (pobiRight % 100 / 10) * (pobiRight % 10);
            } else {
                pobiRightMul = (pobiRight / 100) * (pobiRight % 100 / 10) * (pobiRight % 10);
            }

            int findPobiMax[] = {pobiLeftSum, pobiRightSum, pobiLeftMul, pobiRightMul};
            Arrays.sort(findPobiMax);
            pobiScore = findPobiMax[3];


            int crongLeftSum = crongLeft/100 + crongLeft % 100 / 10 + crongLeft % 10;
            int crongRightSum = crongRight/100 + crongRight % 100 / 10 + crongRight % 10;
            int crongLeftMul, crongRightMul;
            if(crongLeft < 100) {
                crongLeftMul = (crongLeft % 100 / 10) * (crongLeft % 10);
            } else {
                crongLeftMul = (crongLeft/100) * (crongLeft % 100 / 10) * (crongLeft % 10);
            }
            if(crongRight < 100) {
                crongRightMul = (crongRight % 100 / 10) * (crongRight % 10);
            } else {
                crongRightMul = (crongRight/100) * (crongRight % 100 / 10) * (crongRight % 10);
            }

            int findCrongMax[] = {crongLeftSum, crongRightSum, crongLeftMul, crongRightMul};
            Arrays.sort(findCrongMax);
            crongScore = findCrongMax[3];

            if(pobiScore > crongScore) {
                answer = 1;
            } else if(pobiScore < crongScore) {
                answer = 2;
            } else if(pobiScore == crongScore) {
                answer = 0;
            } else {
                answer = -1;
            }

            return answer;
        }
    }
}
