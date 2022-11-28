import React from 'react'
import Comment from './Comment'

// 1. 데이터 리스트 [ 서버 통신과 통신된 결과물 ]
const comments = [
    {
        name : "김원종",
        comment : "세계를 정복할 남자지",
    },
    {
        name : "김원종 2 ",
        comment : " 이 김원종이 오늘 점심 쏜다",
    },
    {
        name : "김원종 3",
        comment : " 사랑은 쟁취하는 것 ",
    },
];

// map vs forEach
// 리스트명.map( ( 반복변수명 ) => { 실행문 } )
function CommentList( props ){
    return(
        <div>
            { comments.map( (c)=>{
                return(
                    <Comment name={c.name} comment={c.comment} />
                );
            } ) }
         </div>
    );
}
export default CommentList