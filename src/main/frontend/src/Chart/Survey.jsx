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
    const onChange = (e)=> { setNum(e.target.value); alert(num)}
    const onChange2 = (e)=> { setNum2(e.target.value); alert(num2)}
    const onChange3 = (e)=> { setNum3(e.target.value); alert(num3)}
    const onChange4 = (e)=> { setNum4(e.target.value); alert(num4)}
    const onChange5 = (e)=> { setNum5(e.target.value); alert(num5)}
    const onChange6 = (e)=> { setNum6(e.target.value); alert(num6)}
    const onChange7 = (e)=> { setNum7(e.target.value); alert(num7)}
    const onChange8 = (e)=> { setNum8(e.target.value); alert(num8)}
    const onChange9 = (e)=> { setNum9(e.target.value); alert(num9)}
    const onChange10 = (e)=> { setNum10(e.target.value); alert(num10)}



    return(
        <div>
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
                        <td><input class="skin" type="radio" onChange={onChange} name="s1" value="3"/></td>
                        <td><input class="skin" type="radio" onChange={onChange} name="s1" value="6"/></td>
                        <td><input class="skin" type="radio" onChange={onChange} name="s1" value="9"/></td>
                        <td><input class="skin" type="radio" onChange={onChange} name="s1" value="12"/></td>
                        <td><input class="skin" type="radio" onChange={onChange} name="s1" value="15"/></td>
                    </tr>
                    <tr>
                        <td>피지분비가 활발하게 일어난다.</td>
                        <td><input class="skin" type="radio" onChange={onChange2} name="s2" value="2"/></td>
                        <td><input class="skin" type="radio" onChange={onChange2} name="s2" value="4"/></td>
                        <td><input class="skin" type="radio" onChange={onChange2} name="s2" value="6"/></td>
                        <td><input class="skin" type="radio" onChange={onChange2} name="s2" value="8"/></td>
                        <td><input class="skin" type="radio" onChange={onChange2} name="s2" value="10"/></td>
                    </tr>
                    <tr>
                        <td>피부에 윤기가 있다고 생각한다.</td>
                        <td><input class="skin" type="radio" name="s3" value="2"/></td>
                        <td><input class="skin" type="radio" name="s3" value="4"/></td>
                        <td><input class="skin" type="radio" name="s3" value="6"/></td>
                        <td><input class="skin" type="radio" name="s3" value="8"/></td>
                        <td><input class="skin" type="radio" name="s3" value="10"/></td>
                    </tr>
                    <tr>
                        <td>세안 후 피부당김이 있다.</td>
                        <td><input class="skin" type="radio" name="s4" value="15"/></td>
                        <td><input class="skin" type="radio" name="s4" value="12"/></td>
                        <td><input class="skin" type="radio" name="s4" value="9"/></td>
                        <td><input class="skin" type="radio" name="s4" value="6"/></td>
                        <td><input class="skin" type="radio" name="s4" value="3"/></td>
                    </tr>
                    <tr>
                        <td>T존에 유분기가 있다.</td>
                        <td><input class="skin" type="radio" name="s5" value="2"/></td>
                        <td><input class="skin" type="radio" name="s5" value="4"/></td>
                        <td><input class="skin" type="radio" name="s5" value="6"/></td>
                        <td><input class="skin" type="radio" name="s5" value="8"/></td>
                        <td><input class="skin" type="radio" name="s5" value="10"/></td>
                    </tr>
                    <tr>
                        <td>부분적이나 전체적으로 하얀 각질이 일어난다.</td>
                        <td><input class="skin" type="radio" name="s6" value="15"/></td>
                        <td><input class="skin" type="radio" name="s6" value="12"/></td>
                        <td><input class="skin" type="radio" name="s6" value="9"/></td>
                        <td><input class="skin" type="radio" name="s6" value="6"/></td>
                        <td><input class="skin" type="radio" name="s6" value="3"/></td>
                    </tr>
                    <tr>
                        <td>피부에 트러블이 잘 생긴다.</td>
                        <td><input class="skin" type="radio" name="s7" value="2"/></td>
                        <td><input class="skin" type="radio" name="s7" value="4"/></td>
                        <td><input class="skin" type="radio" name="s7" value="6"/></td>
                        <td><input class="skin" type="radio" name="s7" value="8"/></td>
                        <td><input class="skin" type="radio" name="s7" value="10"/></td>
                    </tr>
                    <tr>
                        <td>세안 후 1시간 이내에 기름이 많아진다.</td>
                        <td><input class="skin" type="radio" name="s8" value="2"/></td>
                        <td><input class="skin" type="radio" name="s8" value="4"/></td>
                        <td><input class="skin" type="radio" name="s8" value="6"/></td>
                        <td><input class="skin" type="radio" name="s8" value="8"/></td>
                        <td><input class="skin" type="radio" name="s8" value="10"/></td>
                    </tr>
                    <tr>
                        <td>얼굴이 전반적으로 건조하다.</td>
                        <td><input class="skin" type="radio" name="s9" value="15"/></td>
                        <td><input class="skin" type="radio" name="s9" value="12"/></td>
                        <td><input class="skin" type="radio" name="s9" value="9"/></td>
                        <td><input class="skin" type="radio" name="s9" value="6"/></td>
                        <td><input class="skin" type="radio" name="s9" value="3"/></td>
                    </tr>
                    <tr>
                        <td>전체적으로 피부가 탄력적이라고 생각한다.</td>
                        <td><input class="skin" type="radio" name="s10" value="2"/></td>
                        <td><input class="skin" type="radio" name="s10" value="4"/></td>
                        <td><input class="skin" type="radio" name="s10" value="6"/></td>
                        <td><input class="skin" type="radio" name="s10" value="8"/></td>
                        <td><input class="skin" type="radio" name="s10" value="10"/></td>
                    </tr>
                    <tr>
                        <td>평소에 피부 수분이 부족하다고 생각한다.</td>
                        <td><input class="skin1" type="radio" name="s11" value="1"/></td>
                        <td><input class="skin1" type="radio" name="s11" value="2"/></td>
                        <td><input class="skin1" type="radio" name="s11" value="3"/></td>
                        <td><input class="skin1" type="radio" name="s11" value="4"/></td>
                        <td><input class="skin1" type="radio" name="s11" value="5"/></td>
                    </tr>
                    <tr>
                        <td>입술이 쉽게 건조해진다.</td>
                        <td><input class="skin1" type="radio" name="s12" value="1"/></td>
                        <td><input class="skin1" type="radio" name="s12" value="2"/></td>
                        <td><input class="skin1" type="radio" name="s12" value="3"/></td>
                        <td><input class="skin1" type="radio" name="s12" value="4"/></td>
                        <td><input class="skin1" type="radio" name="s12" value="5"/></td>
                    </tr>
                    <tr>
                        <td>피부가 작은 자극에도 쉽게 붉어진다.</td>
                        <td><input type="radio" name="s13" value="0"/></td>
                        <td><input type="radio" name="s13" value="0"/></td>
                        <td><input type="radio" name="s13" value="0"/></td>
                        <td><input type="radio" name="s13" value="0"/></td>
                        <td><input type="radio" name="s13" value="1"/></td>
                    </tr>
                </tbody>
            </table>
            <button id="actres" class="btn btn-primary" data-title="결과보기"  data-toggle="modal" data-target="#result" >결과보기</button>
            <button type="button" onClick={abc}> abc </button>
        </div>
    );



}