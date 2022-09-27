function solution(answers) {
    const pattern1 = [1,2,3,4,5];
    const pattern2 = [2,1,2,3,2,4,2,5];
    const pattern3 = [3,3,1,1,2,2,4,4,5,5];
    const answer = [];
    const supo = new Map();
    
    for(let i=1;i<=3;i++)  
        supo.set(i,0);

    answers.forEach((val, idx) => {
        if(pattern1[idx%pattern1.length] === val)
            supo.set(1,supo.get(1)+1)
        if(pattern2[idx%pattern2.length] === val)
            supo.set(2,supo.get(2)+1)
        if(pattern3[idx%pattern3.length] === val)
            supo.set(3,supo.get(3)+1)
    });
    const max = Math.max(...supo.values());
    
    [...supo].forEach(([key,value]) => {
        if(value === max){
            answer.push(key);
        }
    })
    
    // answer.sort((a,b) => a-b); 없어도 될 듯
    
    return answer;
}