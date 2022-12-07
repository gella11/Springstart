import React , {useState} from 'react';

export default function Survey(){




    const abc = () => { alert("ad")  }
    const[num, setNum ] = useState(0)
    const[num2, setNum2 ] = useState(0)
    const[num3, setNum3 ] = useState(0)
    const[num4, setNum4 ] = useState(0)
    const[num5, setNum5 ] = useState(0)
    const[num6, setNum6 ] = useState(0)
    const[num7, setNum7 ] = useState(0)
    const[num8, setNum8 ] = useState(0)
    const[num9, setNum9 ] = useState(0)
    const[num10, setNum10 ] = useState(0)
    const[num11, setNum11 ] = useState(0)
    const[num12, setNum12 ] = useState(0)
    const[num13, setNum13 ] = useState(0)
    const[num14, setNum14 ] = useState(0)
    const[num15, setNum15 ] = useState(0)
    const onChange  = (e)=> { setNum (parseInt(e.target.value)); alert(num)}
    const onChange2 = (e)=> { setNum2(parseInt(e.target.value)); alert(num2)}
    const onChange3 = (e)=> { setNum3(parseInt(e.target.value)); alert(num3)}
    const onChange4 = (e)=> { setNum4(parseInt(e.target.value)); alert(num4)}
    const onChange5 = (e)=> { setNum5(parseInt(e.target.value)); alert(num5)}
    const onChange6 = (e)=> { setNum6(parseInt(e.target.value)); alert(num6)}
    const onChange7 = (e)=> { setNum7(parseInt(e.target.value)); alert(num7)}
    const onChange8 = (e)=> { setNum8(parseInt(e.target.value)); alert(num8)}
    const onChange9 = (e)=> { setNum9(parseInt(e.target.value)); alert(num9)}
    const onChange10 = (e)=> { setNum10(parseInt(e.target.value)); alert(num10)}
    const onChange11 = (e)=> { setNum11(parseInt(e.target.value)); alert(num11)}
    const onChange12 = (e)=> { setNum12(parseInt(e.target.value)); alert(num12)}
    const onChange13 = (e)=> { setNum13(parseInt(e.target.value)); alert(num13)}
    const onChange14 = (e)=> { setNum14(parseInt(e.target.value)); alert(num14)}
    const onChange15 = (e)=> { setNum15(parseInt(e.target.value)); alert(num15)}

    const[sum , setSum] = useState(0)
    const[sum2 , setSum2] = useState(0)
    const[sum3 , setSum3] = useState(0)
    const[sum4 , setSum4] = useState(0)
    const[sum5 , setSum5] = useState(0)
    const sumpoint = () => { setSum(num+num2+num3+num4+num5) ; alert(sum)} // 이해도
    const sumpoint2 = () => { setSum(num6+num7+num8+num9+num10) ; alert(sum)} // 적극성
    const sumpoint3 = () => { setSum(num11+num12+num13+num14+num15) ; alert(sum)} // 독창성

    const sumpoint4 = () => { setSum(num+num2+num3+num4+num5) ; alert(sum)} // 책임감
    const sumpoint5 = () => { setSum(num+num2+num3+num4+num5) ; alert(sum)} // 노력도


    return(
        <div style={{padding : 50}}>
            <table class="table">
                <thead>
                    <tr>
                        <td>항목</td>
                        <td>매우아니다/매우작다/매우적다</td>
                        <td>아니다/작다/적다</td>
                        <td>보통이다</td>
                        <td>그렇다/크다/많다</td>
                        <td>매우 그렇다/매우 크다/매우 많다</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>모공크기가 전박적으로 크다.</td>
                        <td><input className="skin" type="radio" onChange={onChange} name="s1" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange} name="s1" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange} name="s1" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange} name="s1" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange} name="s1" value="5"/></td>
                    </tr>
                    <tr>
                        <td>피지분비가 활발하게 일어난다.</td>
                        <td><input className="skin" type="radio" onChange={onChange2} name="s2" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange2} name="s2" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange2} name="s2" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange2} name="s2" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange2} name="s2" value="5"/></td>
                    </tr>
                    <tr>
                        <td>피부에 윤기가 있다고 생각한다.</td>
                        <td><input className="skin" type="radio" onChange={onChange3} name="s3" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange3} name="s3" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange3} name="s3" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange3} name="s3" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange3} name="s3" value="5"/></td>
                    </tr>
                    <tr>
                        <td>세안 후 피부당김이 있다.</td>
                        <td><input className="skin" type="radio" onChange={onChange4} name="s4" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange4} name="s4" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange4} name="s4" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange4} name="s4" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange4} name="s4" value="5"/></td>
                    </tr>
                    <tr>
                        <td>T존에 유분기가 있다.</td>
                        <td><input className="skin" type="radio" onChange={onChange5} name="s5" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange5} name="s5" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange5} name="s5" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange5} name="s5" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange5} name="s5" value="5"/></td>
                    </tr>
                    <tr>
                        <td>부분적이나 전체적으로 하얀 각질이 일어난다.</td>
                        <td><input className="skin" type="radio" onChange={onChange6} name="s6" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange6} name="s6" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange6} name="s6" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange6} name="s6" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange6} name="s6" value="5"/></td>
                    </tr>
                    <tr>
                        <td>피부에 트러블이 잘 생긴다.</td>
                        <td><input className="skin" type="radio" onChange={onChange7} name="s7" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange7} name="s7" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange7} name="s7" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange7} name="s7" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange7} name="s7" value="5"/></td>
                    </tr>
                    <tr>
                        <td>세안 후 1시간 이내에 기름이 많아진다.</td>
                        <td><input className="skin" type="radio" onChange={onChange8} name="s8" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange8} name="s8" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange8} name="s8" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange8} name="s8" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange8} name="s8" value="5"/></td>
                    </tr>
                    <tr>
                        <td>얼굴이 전반적으로 건조하다.</td>
                        <td><input className="skin" type="radio" onChange={onChange9} name="s9" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange9} name="s9" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange9} name="s9" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange9} name="s9" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange9} name="s9" value="5"/></td>
                    </tr>
                    <tr>
                        <td>전체적으로 피부가 탄력적이라고 생각한다.</td>
                        <td><input className="skin" type="radio" onChange={onChange10} name="s10" value="1"/></td>
                        <td><input className="skin" type="radio" onChange={onChange10} name="s10" value="2"/></td>
                        <td><input className="skin" type="radio" onChange={onChange10} name="s10" value="3"/></td>
                        <td><input className="skin" type="radio" onChange={onChange10} name="s10" value="4"/></td>
                        <td><input className="skin" type="radio" onChange={onChange10} name="s10" value="5"/></td>
                    </tr>
                    <tr>
                        <td>평소에 피부 수분이 부족하다고 생각한다.</td>
                        <td><input className="skin1" type="radio" onChange={onChange11} name="s11" value="1"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange11} name="s11" value="2"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange11} name="s11" value="3"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange11} name="s11" value="4"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange11} name="s11" value="5"/></td>
                    </tr>
                    <tr>
                        <td>입술이 쉽게 건조해진다.</td>
                        <td><input className="skin1" type="radio" onChange={onChange12} name="s12" value="1"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange12} name="s12" value="2"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange12} name="s12" value="3"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange12} name="s12" value="4"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange12} name="s12" value="5"/></td>
                    </tr>
                    <tr>
                        <td>입술이 쉽게 건조해진다.</td>
                        <td><input className="skin1" type="radio" onChange={onChange13} name="s13" value="1"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange13} name="s13" value="2"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange13} name="s13" value="3"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange13} name="s13" value="4"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange13} name="s13" value="5"/></td>
                    </tr>
                    <tr>
                        <td>입술이 쉽게 건조해진다.</td>
                        <td><input className="skin1" type="radio" onChange={onChange14} name="s14" value="1"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange14} name="s14" value="2"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange14} name="s14" value="3"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange14} name="s14" value="4"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange14} name="s14" value="5"/></td>
                    </tr>
                    <tr>
                        <td>입술이 쉽게 건조해진다.</td>
                        <td><input className="skin1" type="radio" onChange={onChange15} name="s15" value="1"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange15} name="s15" value="2"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange15} name="s15" value="3"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange15} name="s15" value="4"/></td>
                        <td><input className="skin1" type="radio" onChange={onChange15} name="s15" value="5"/></td>
                    </tr>
                    <tr>
                        <td>피부가 작은 자극에도 쉽게 붉어진다.</td>
                        <td><input type="radio" onChange={onChange13} name="s13" value="1"/></td>
                        <td><input type="radio" onChange={onChange13} name="s13" value="2"/></td>
                        <td><input type="radio" onChange={onChange13} name="s13" value="3"/></td>
                        <td><input type="radio" onChange={onChange13} name="s13" value="4"/></td>
                        <td><input type="radio" onChange={onChange13} name="s13" value="5"/></td>
                    </tr>
                </tbody>
            </table>
            <button id="actres" class="btn btn-primary" data-title="결과보기"  data-toggle="modal" data-target="#result" >결과보기</button>
            <button type="button" onClick={sumpoint}> 총점 </button>
            <button type="button" onClick={sumpoint}> 이해도 </button>
            <button type="button" onClick={sumpoint2}> 적극성 </button>
            <button type="button" onClick={sumpoint3}> 독창성 </button>
            <button type="button" onClick={sumpoint4}> 책임감 </button>
            <button type="button" onClick={sumpoint5}> 노력도 </button>
        </div>
    );



}