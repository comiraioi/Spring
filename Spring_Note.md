# Spring 개념 정리

<details>
  <summary><h2> 02~04) Dependency Injection</h2></summary>
  <div markdown="1">
    <div>
      <dt><h3>Spring DI(Dependency Injection)</h3></dt>
      <dd>객체(Bean) 간의 의존 관계를 외부의 파일 (스프링 설정 파일) 에서 설정하는 것</dd><br>
      <ul>
        <li>스프링 설정 파일: Bean을 관리함 (자바의 객체를 Spring에서는 Bean으로 부름)</li>
        <li>기본 파일명: applicationContext.xml</li>
        <li>위치: src/main/resources 에서 Spring Bean Configuration File 생성</li>
        <li>스프링 컨테이너 => Inversion of Control(제어의 역전)</li>
        : 개발자가 직접 객체를 언제 생성하고 없앨지 결정하는 것이 아니라 컨테이너에게 일임함
        <li>작성 방법: 스프링 컨테이너를 통해 작성 (아래 주입의 종류 참고)</li>
      </ul>
    </div>
    <hr style="border:dashed">
    <div>
      <dt><b>BeanFactory 인터페이스(기본 IoC 컨테이너)</b></dt>
      <dd>Bean을 생성하고 설정, 관리하는 역할을 수행</dd><br>
      <div>
        <ul><b>[방법1]</b>
          <ul>
            <li>스프링 설정 파일(appContext.xml)을 관리하는 resource(출처) 객체 만들기</li>
            => Resource resource = new ClassPathResource("appContext.xml");
            <li>Bean 공장을 이용해 resource를 참고하여 Bean 생성 후 getBean() 메소드로 가져오기</li>
            : obj 타입을 반환하므로 해당 타입으로 다운캐스팅을 해줘야 함 <br>
          </ul>
          <pre>BeanFactory factory = new XmlBeanFactory(resource);<br>타입 객체 = (타입)factory.getBean("참조변수");</pre>
        </ul>
        <ul><b>[방법2]</b>
          <pre>ApplicationContext context = new FileSystemXmlApplicationContext("appContext.xml");<br>타입 객체 = (타입)context.getBean("참조변수");</pre>
        </ul>
        <ul><b>[방법3]</b>
          <pre>AbstractApplicationContext context = new GenericXmlApplicationContext("aopExam.xml");<br>타입 객체 = (타입)context.getBean("참조변수");</pre>
        </ul>
      </div>
    </div>
    <hr/>
    <div>
      <dt><h3>Injection(주입)의 종류</h3></dt>
      <ul><h4>생성자를 통한 값 주입</h4>
        <ul>
          <li>
            <b>[방법1]</b>
            <pre>&lt;constructor-arg&gt;<br> &nbsp;&nbsp; &lt;value type="타입"&gt;값&lt;/value&gt;<br>&lt;/constructor-arg&gt;</pre>
          </li>
          <li><b>[방법2]</b>
          <pre>&lt;constructor-arg value="값" type="타입"&gt;</pre>
        </ul>
      </ul>
      <ul><h4>setter를 통한 주입</h4>
        <ul>
          <li><b>값 주입</b>
            <ul>
              <li><b>[방법1]</b></li>
              <pre>&lt;property name="변수명"&gt;<br> &nbsp;&nbsp; &lt;value type="타입"&gt;값&lt;/value&gt;<br>&lt;/property&gt;</pre>
              <li><b>[방법2]</b></li>
              <pre>&lt;property name="변수명" value="값3"/&gt;</pre>
            </ul>
          </li>
          <li><b>객체 주입</b>
            <pre>&lt;property name="객체명"&gt;<br> &nbsp;&nbsp; &lt;ref bean ="객체"&gt;값&lt;/value&gt;<br>&lt;/property&gt;</pre>
          </li>
        </ul>
      </ul>
      <ul>
        <dt><h4>네임스페이스를 통한 주입</h4></dt>
        <dd>: Namespaces 탭에서 사용할 네임스페이스 선택</dd><br>
        <ul>
          <li><b>네임스페이스 p(property)</b>: setter로 주입</li>
          <pre>&lt;bean id="객체명" class="클래스명" p:setter 메서드명="값"/&gt;</pre>
          <li><b>네임스페이스 c(constructor)</b>: 생성자로 객체, 값 주입</li>
          <pre>&lt;bean id="객체명" class="클래스명" c:매개변수명-ref="객체명" c:변수명="값"&gt;</pre>
        </ul>
      </ul>
    </div>
  </div>
</details>

