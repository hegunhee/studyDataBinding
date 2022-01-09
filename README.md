이 repo는 DataBinding을 공부하기위해 만든것입니다.  
## Databinding이란?  
xml파일에 Data를 연결(binding)해서 사용할 수 있게 도와주며 **Android JetPack라이브러리의 하나의 기능** 입니다.  
## data binding은 왜 사용할까?  
### 데이터 바인딩을 사용하면 데이터를 UI 요소에 연결하기 위해 필요한 코드를 최소화할 수 있습니다.  
data binding을 사용했을 때, 당장 가시적으로 보이는 장점들을 꼽자면 다음과 같습니다.  
* findViewId() 를 호출하지 않아도, 자동으로 xml에 있는 View 들을 만들어줍니다.  
* RecyclerView에 각각의 item을 set 해주는 작업도 자동으로 진행됩니다.  
* data가 바뀌면 자동으로 View를 변경하게 할 수 있습니다.  
* xml 리소스만 보고도 View에 어떤 데이터가 들어가는지 파악 가능합니다.  
* 코드 가독성이 좋아지고, 상대적으로 코드량이 줄어듭니다.  
**또한 데이터 바인딩은 MVP 또는 MVVM 패턴을 구현하기 위해 유용하게 사용됩니다.**  
  
그러나, data binding이 장점만 있는것은 아닙니다.  
클래스 파일이 많이 생기고, 빌드 속도가 느려지는 등 단점들도 존재합니다.  
그래서 data binding은 data binding 단독으로 사용하는 것보다 MVVM 또는 MVP 아키텍처와 함께 사용해야 빛을 발합니다.
