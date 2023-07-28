# Spring 개념 정리

<details>
  <summary><h2> 02~04) Dependency Injection</h2></summary>
  <div markdown="1">
    <div>
      <dt><h2>Spring DI(Dependency Injection)</h2></dt>
      <dd>객체(Bean) 간의 의존 관계를 외부의 파일 (스프링 설정 파일) 에서 설정하는 것</dd><br>
      <ul>
        <li>스프링 설정 파일: Bean을 관리함 (자바의 객체를 Spring에서는 Bean으로 부름)</li>
        <li>기본 파일명: applicationContext.xml</li>
        <li>위치: src/main/resources 에서 Spring Bean Configuration File 생성</li>
        <li>스프링 컨테이너 &rArr; Inversion of Control(제어의 역전)</li>
        : 개발자가 직접 객체를 언제 생성하고 없앨지 결정하는 것이 아니라 컨테이너에게 일임함
        <li>작성 방법: 스프링 컨테이너를 통해 작성 (아래 주입의 종류 참고)</li>
      </ul>
    </div>
    <div>
      <dt><b>BeanFactory 인터페이스(기본 IoC 컨테이너)</b></dt>
      <dd>Bean을 생성하고 설정, 관리하는 역할을 수행</dd><br>
      <div>
        <ul><b>[방법1]</b>
          <ul>
            <li>스프링 설정 파일(appContext.xml)을 관리하는 resource(출처) 객체 만들기</li>
            &rArr; Resource resource = new ClassPathResource("appContext.xml");
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
      <ul><dt><h2>Injection(주입)의 종류</h2></dt>
      <li><h3>생성자를 통한 값 주입</h3>
        <ul>
          <li>
            <b>[방법1]</b>
            <pre>&lt;constructor-arg&gt;<br> &nbsp;&nbsp; &lt;value type="타입"&gt;값&lt;/value&gt;<br>&lt;/constructor-arg&gt;</pre>
          </li>
          <li><b>[방법2]</b>
          <pre>&lt;constructor-arg value="값" type="타입"&gt;</pre>
        </ul>
      </li>
      <li><h3>setter를 통한 주입</h3>
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
      </li>
      <li>
        <dt><h3>네임스페이스를 통한 주입</h4></d3>
        <dd>: Namespaces 탭에서 사용할 네임스페이스 선택</dd><br>
        <ul>
          <li><b>네임스페이스 p(property)</b>: setter로 주입</li>
          <pre>&lt;bean id="객체명" class="클래스명" p:setter 메서드명="값"/&gt;</pre>
          <li><b>네임스페이스 c(constructor)</b>: 생성자로 객체, 값 주입</li>
          <pre>&lt;bean id="객체명" class="클래스명" c:매개변수명-ref="객체명" c:변수명="값"&gt;</pre>
        </ul>
      </li>
      </ul>
    </div>
  </div>
</details>

<details>
  <summary><h2> 05~06) AOP: Aspect Oriented Programming</h2></summary>
  <div markdown="1">
    <div>
      <dt><h2>관점 지향 프로그래밍 (AOP) </h2></dt>
      <dd>객체 지향 언어에 의해 추구된 모듈화에 따라 증가한 중복 코드 등을 뽑아 내어 공통으로 처리하는 방식</dd>
      <ul>
        <li>
          <b>개념</b>
          <ul>
            <li>기능별 코드 분리: 기능의 통합은 AOP 프레임워크가 담당</li>
            <li>관점의 분리(Seperation of Concerns)</li>
            <li>핵심 기능(core concern)과 전체에 적용되는 공통 기능(cross-cutting concern)을 기준으로 프로그래밍해 공통 모듈을 여러 코드에 쉽게 적용할 수 있도록 함</li>
          </ul>
        </li>
        <li>
          <b>관련 용어</b>
          <ul>
            <li>aspect: 핵심(공통) 관심 사항</li>
            <li>advice: 핵심 사항을 언제 적용할것인지 정함</li>
            <li>pointcut: 핵심 사항을 표현한 클래스(Target Object)내의 특정 메소드를 표현</li>
          </ul>
        </li>
        <li>
          <b>AOP xml 설정</b>
          <ul>
            <li>before/after: 주요 기능 전에 실행할지 후에 실행할지 결정</li>
            <li>order: 메서드 실행순서 지정, 0~10사이의 수
              <ul><li>before: 숫자가 작은 것부터 실행</li><li>after: 숫자가 큰 것부터 실행</li></ul>
            </li>
          </ul>
          <pre>&lt;aop:config&gt; &nbsp;&nbsp; &lt;!-- aop 설정 --&gt;<br> &nbsp &lt;aop:aspect ref="객체명" order="1"&gt; &nbsp;&nbsp; &lt;!--핵심사항 지정(ref: 공통 기능을 구현하고 있는 객체 명시)--&gt; <br> &nbsp;&nbsp;&nbsp;&nbsp; &lt;aop:after method="메서드명" pointcut=""&gt; &nbsp;&nbsp; &lt;!-- pointcut(호출할 메서드)을 설정 --&gt;<br> &nbsp; &lt;aop:aspect&gt; <br>&lt;aop:config&gt;</pre>
        </li>
        <li>
          <b>AspectJ Pointcut Expression 예시</b>
          <ul>
            <li>execution(public void set*(..)): 리턴 타입 void, 메소드명이 set으로 시작, 매개변수가 0개 이상인 메소드 호출</li>
            <li>execution(* mypkg.core.*.*()): 리턴 타입 무관, mypkg.core 패키지의 매개변수가 없는 모든 메소드 호출</li>
            <li>execution(*.mypkg.core..*.*(..)): 리턴 타입 무관, mypkg.core 패키지 또는 그 하위 패키지에 있는 매개변수가 0개 이상인 메소드 호출</li>
            <li>execution(Integer mypkg.WriteArticleService.write(..)): 리턴 타입이 Integer인 WriteArticleService 인터페이스의 write() 메소드 호출</li>
            <li>execution(* get*(*, *)): 리턴 타입 무관, 이름이 get으로 시작하고 2개의 파라미터를 갖는 메소드 호출</li>
          </ul>
        </li>
        <li>
          <b>AOP에 필요한 dependency (pom.xml)</b>
          <pre>&lt;dependency&gt; <br> &nbsp;&nbsp; &lt;groupId>org.aspectj&lt;/groupId&gt; <br> &nbsp;&nbsp; &lt;artifactId>aspectjrt&lt;/artifactId&gt; <br> &nbsp;&nbsp; &lt;version>${aspectj.version}&lt;/version&gt; &nbsp; &lt;!-- properties에 버전 작성 --&gt; <br> &nbsp;&nbsp; &lt;scope>runtime&lt;/scope&gt; <br> &lt;/dependency&gt; <br> &lt;dependency&gt; <br> &nbsp;&nbsp; &lt;groupId&gt;org.aspectj&lt;/groupId&gt; <br> &nbsp;&nbsp; &lt;artifactId&gt;aspectjtools&lt;/artifactId&gt; <br> &nbsp;&nbsp; &lt;version&gt;${aspectj.version}&lt;/version&gt; <br> &nbsp;&nbsp; &lt;scope>runtime&lt;/scope&gt; <br> &lt;/dependency&gt; </pre>
        </li>
      </ul>
    </div>
  </div>
</details>

<details>
  <summary><h2> 07~09) MVC (Model/View/Controller)</h2></summary>
  <div markdown="1">
    <div>
      <dt><h2>Spring 프로젝트 실행 흐름</h2></dt>
      <dd>
        ① pom.xml(dependecy를 읽고 메이븐 중앙저장소에서 자동으로 jar 파일 추가 <br>
        ② C:\Users\사용자명\.m2 폴더에 자동 저장)  <br>
        ③ web.xml &rarr; root-context.xml &rarr; servlet-context.xml
      </dd>
      <ul>
        <li>
          <dt><h3>web.xml<h3></dt>
          <dd>한글 설정 &rarr; 프로젝트 전반에 걸쳐 사용할 설정이 있으면 root-context.xml로 이동 명령 &rarr; &lt;servlet-mapping&gt;으로 "/" 요청 &rarr; DispatcherServlet: 최초 요청("/")을 받는 서블릿 &rarr; servlet-context.xml로 이동 명령</dd><br>
          <b>web.xml 한글 설정</b>: 캐릭터 인코딩 처리를 위한 필터 설정
          <pre>&lt;filter&gt; <br> &nbsp;&nbsp; &lt;filter-name&gt;encodingFilter&lt;/filter-name&gt; <br> &nbsp;&nbsp; &lt;filter-class&gt;org.springframework.web.filter.CharacterEncodingFilter&lt;/filter-class&gt; <br> &nbsp;&nbsp; &lt;init-param&gt; <br> &nbsp;&nbsp;&nbsp;&nbsp; &lt;param-name&gt;encoding&lt;/param-name&gt; <br> &nbsp;&nbsp;&nbsp;&nbsp; &lt;param-value&gt;UTF-8&lt;/param-value&gt; <br> &nbsp;&nbsp; &lt;/init-param&gt; <br> &nbsp;&nbsp; &lt;init-param&gt; <br> &nbsp;&nbsp;&nbsp;&nbsp; &lt;param-name&gt;forceEncoding&lt;/param-name&gt; <br> &nbsp;&nbsp;&nbsp;&nbsp; &lt;param-value&gt;true&lt;/param-value&gt; <br> &nbsp;&nbsp; &lt;/init-param&gt; <br>&lt;/filter&gt; <br>&lt;filter-mapping&gt; <br> &nbsp;&nbsp; &lt;filter-name&gt;encodingFilter&lt;/filter-name&gt; <br> &nbsp;&nbsp; &lt;url-pattern&gt;/*&lt;/url-pattern&gt; <br>&lt;/filter-mapping&gt;</pre>
        </li>
        <li>
          <h3>HomeController.java</h3>
          <ul>
            <li><b>@Controller</b>: 컨트롤러 어노테이션이 없으면 요청("/")이 들어와도 자동으로 실행되지 않음</li>
            <li><b>@RequestMapping</b>: 요청 방식 설정, view에 넘길 데이터 설정</li>
            <li>"/" 요청이 get방식으로 들어오면 home 메서드가 자동으로 실행됨 </li>
            <li><b>home 메서드</b>: 포맷 설정한 Date를 model에 담고 home(view)으로 전달, home 넘김 <br>
                &rArr; /WEB-INF/views/jsp 파일(view)은 직접 실행 불가능, controller를 통해서만 실행됨
            </li>
          </ul>
        </li>
        <li>
          <h3>servlet-context.xml</h3>
          <ul>
            <li><bean> 태그로 객체 생성, <property>로 prefix, suffix 변수에 setter로 값 주입</li>
            <li><b>prefix</b>: "/WEB-INF/views/"</li>
            <li><b>suffix</b>: ".jsp"</li>
            <li>기본 패키지(com.spring.ex) 스캔 &rarr; Controller 클래스 확인 &rarr; home 리턴됨</li>
            <li>prefix와 suffix 사이에 home 들어옴 &rarr; /WEB-INF/views/home.jsp &rarr; home.jsp 실행됨</li>
          </ul>
        </li>
      </ul>
    </div>
    </div>
    <hr/>
      <div>
        <dt><h2>RequestMapping</h2></dt>
        <dd>src/main/java > com.spring.ex > HomeController.java 또는 사용자가 작성한 컨트롤러</dd>
        <ul>
          <li><h3>@RequestMapping(value = "요청명", method = RequestMethod.GET)</h3>
            <ul>
              <li>get 방식으로 요청명이 들어오면 메서드 실행</li>
              <li>요청명: /폴더명/파일명 (폴더명 앞 "/" 생략 가능) <br>
                  &rArr; 다른 컨트롤러에 작성하더라도 같은 프로젝트 안에서 요청명은 중복되면 안됨 (단, method가 다르면 가능) <br>
                  &rArr; 한 Controller 클래스 안에서 폴더명이 동일할경우 @Controller 어노테이션 밑에 @RequestMapping("중복폴더명")으로 작성 가능 <br>
              </li>
              <li>method 작성하지 않으면 get,post 방식 무관</li>
            </ul>
          </li>
          <li><h3>view로 이동하는 메서드 작성</h3>
            <ul>
              <li><b>[방법1: 데이터 없이 바로 뷰로 이동]</b></li>
              <pre>@RequestMapping(value = "요청명")	 //value = 없이 요청명만 작성 가능<br>public String 메서드명() {<br> &nbsp;&nbsp; return "폴더명.파일명";	// /WEB-INF/views/폴더명.파일명.jsp <br>}</pre>
              <li><b>[방법2: 데이터(model 또는 request로 속성 설정)를 가지고 뷰로 이동]</b></li>
              <pre>@RequestMapping("요청명") <br>public String 메서드명(Model model, HttpServletRequest request) { <br> &nbsp;&nbsp; model.addAttribute("변수1","값1");  &nbsp;&nbsp;//변수에 값을 넣어 model에 담아 뷰로 넘김 (즉, 속성설정과 동일한 기능) <br> &nbsp;&nbsp; request.setAttribute("변수2","값2");	&nbsp;&nbsp;//jsp에서 받을때:request.getAttribute("변수"), ${requestScope.변수} <br><br> &nbsp;&nbsp; return "member.insertForm"; <br>}</pre>
              <li><b>[방법3: ModelAndView로 데이터를 가지고 뷰로 이동]</b></li>
              <pre>@RequestMapping("요청명") <br>public ModelAndView 메서드명() { <br> &nbsp;&nbsp; ModelAndView mav = new ModelAndView(); <br> &nbsp;&nbsp; /* 모델 */ <br> &nbsp;&nbsp; mav.addObject("변수1", "값1"); <br> &nbsp;&nbsp; mav.addObject("변수2", "값2"); <br> &nbsp;&nbsp; /* 뷰 */	<br> &nbsp;&nbsp; mav.setViewName("폴더명/파일명"); <br><br> &nbsp;&nbsp; return mav; <br>}</pre>
              <li><b>[방법4: ModelAndView로 데이터 없이 바로 뷰로 이동]</b></li>
              <pre>@RequestMapping("요청명") <br>public ModelAndView 메서드명() { <br> &nbsp;&nbsp; ModelAndView mav = new ModelAndView("폴더명/파일명"); <br><br> &nbsp;&nbsp; return mav; <br>}</pre>
            </ul>
          </li>
          <li>
            <dt><h3>Parameter로 넘어온(Get 방식 요청) 데이터 받기</h3></dt>
            <dd>뷰에서 요청명 뒤에 get방식으로 변수에 값을 전달 &rArr; ex) http://localhost:8080/ex/person/input?name=kim&age=20</dd><br>
            <ul>
              <li><b>방법1: 메서드 매개변수 &rarr; HttpServletRequest request</b></li>
                &rArr; 메서드에서 request.getParameter()로 받기 / 뷰에서도 request.getParameter(), ${param}으로 받을 수 있음
              <li><b>방법2: 매서드 매개변수 &rarr; @RequestParam("파라미터명") String 변수명, ... </b></li>
                &rArr; 뷰에서 바로 request.getParameter(), ${param}으로 받을 수 있음
                &rArr; Bean으로 묶어서 넘기기
                  · bean을 속성설정(model,Attribute)해서 넘기기 &rarr; 뷰에서 request.getAttribute(). ${requestScope}으로 받을 수 있음
                  · 커맨드객체를 매개변수로 설정하기 &rarr; 객체생성, setter, 모델설정까지 자동으로 됨
              <li>form에서 get방식으로 변수에 값을 전달(parameter)</li>
              : form action에 "요청명" 작성 <br>
                &rarr; 이때, 중복되는 요청명이 있으면 반드시 생략 또는 "<%=request.getContextPath()%>/중복요청명/요청명"과 같이 작성
            </ul>
          </li>
        </ul>
      </div>
</details>

<details>
  <summary><h2>10) Redirect</h2></summary>
  <div markdown="1">
    <div>
      <dt><h2>redirect</h2></dt>
      <dd>뷰에서 <b>"redirect:/"</b> 접두어에 뷰 이름 붙이면 컨트롤러의 요청이 실행됨 </dd>
    </div>
    <div>
      <dt><h2>데이터 전달</h2></dt>
      <dd>jsp 파일이 아닌 redirect로 넘어가면 새로운 request 객체가 생성되어 form에서 입력한 값이 유지되지 않음(request.param, request.attr=null) <br>
          &rArr; <b>map</b>으로 묶어서 넘겨야함
      </dd>
      <ul>
        <li>form에서 action 요청 시 &rarr; 매개변수(HttpServletRequest request, RedirectAttributes redirectAttr)</li>
        <ul>
          <li>map 객체 생성: Map&lt;String,Object&gt; map = new HashMap&lt;String, Object&gt;();</li>
          <li>map에 (키,값) 담기: map.put("mname", name);</li>
          <li>map 객체 속성 설정: redirectAttr.addFlashAttribute("redirectMap",map);</li>
        </ul>
        <li>redirect로 넘어간 요청: map 출력해도 null</li>
        <li>jsp 파일: ${requestScope.redirectMap.키}으로 출력하면 결과값 나옴</li>
      </ul>
    </div>
  </div>
</details>

<details>
  <summary><h2>11) Autowired</h2></summary>
  <div markdown="1">
    <div>
      <dt><h2>@Autowired</h2></dt>
      <dd>필요한 의존 객체의 타입에 해당하는 빈을 자동으로 주입</dd>
    </div>
    <div>
      <ul>
        <li>appContext.xml 생성</li>
        &rArr; &lt;context:component-scan base-package="패키지명"/&gt;
        <li>생성할 객체가 있는 패키지를 스캔</li>
        : ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        <li>어노테이션에 따라 객체 생성, 주입</li>
          <ul>
            <li>@Component("참조변수명"): 객체 생성 (클래스명 참조변수명 = new 클래스명())</li>
            &rarr; 클래스 위에 작성, 참조변수명은 클래스명과 동일해도 무관
            <li>@Autowired: 자식을 자동으로 주입 (setter)</li>
            <li>@Qualifier("참조변수명"): 자식이 2개 이상일 경우 주입하고 싶은 자식의 참조변수 작성</li>
            &rarr; 변수 위에 작성
          </ul>
        <li>@Component("참조변수명")으로 생성한 객체 가져오기</li>
        : 부모타입 참조변수 = (부모타입)context.getBean("참조변수명");	-> 참조변수명은 @Component와 동일
      </ul>
    </div>
  </div>
</details>

<details>
  <summary><h2>12) Validation</h2></summary>
  <div markdown="1">
    <dt><h2>유효성 검사</h2><dt>
    <ul>
      <li>pom.xml에 유효성 검사에 필요한 dependecy 작성</li>
      <li>form 작성</li>
      &rArr; form:form의 기본 method="POST" <-> form의 기본 method="GET"
      <pre>&lt;form:form commandName="커맨드객체로 설정된 모델명(객체 앞글자만 소문자)"&gt;<br> &nbsp;&nbsp; &lt;form:errors cssClass="err(스타일 클래스명)" path="Bean의 변수명"/&gt;	&rArr 에러메세지<br> &lt;/form:form&gt;</pre>
      <li>Bean: 변수 위에 유효성 검사 어노테이션 작성</li>
      <ul>
        <li>유효성 검사</li>
        <ul>
          <li>text: <b>@NotBlank</b>(message="") &rarr; 공백처리 가능</li>
          <li>select: <b>@NotBlank</b>(message=""), <b>@NotEmpty</b>(message="") &rarr; 선택 안했을때 value="" </li>
          <li>checkbox, radio: <b>@NotBlank(message=""), <b>@NotEmpty</b>(message=""), <b>@NotNull</b>(message="")</li>
        </ul>
        <li>글자 수 검사</li>
        <ul>
          <li><b>@Size</b>(min = 3, max = 5, message = "")</li>
          <li><b>@Length</b>(min = 3, max = 5, message = "")</li>
        </ul>
        <li>패턴(정규표현식) 검사</li>
        <ul>
          <li><b>Pattern</b>(regexp = "^[0-9]+$", message = "숫자만 입력하세요")</li>
          <li>유효성 검사 -> 어노테이션 안에서는 /로 열고 닫지 않음 (*: 0번 이상, +: 1번 이상, ^: 시작, $: 끝)</li>
        </ul>
        <li>숫자 범위 검사</li>
        : @<b>Range</b>(min=10, max=100, message="10살 이상, 100살 이하로 작성해야 합니다.")
      </ul>
      <li>뷰(form)</li>
      <li>컨트롤 &rArr; 커맨드 객체 유효성 검사 </li>
      <ul>
        <li>매개변수: @Valid 커맨드 객체(Bean), 유효성검사 결과를 받는 BindingResult result (순서 중요!)</li>
        <li>result.hasErrors(): true면 유효성 검사 에러, false면 setter로 커맨드 객체에 값이 들어옴</li>
      </ul>
    </ul>
  </div>
</details>
