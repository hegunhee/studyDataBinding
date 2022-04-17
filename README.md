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
## two-way-binding  
데이터바인딩으로 버튼을 누르면 에딧텍스트의 text를 textView에 옮기는 작업을 진행하려고 했지만 옮겨지지 않을 뿐 아니라 바인딩한 객체의 데이터또한 변하지 않았습니다.  
왜 그런가 찾아보니 기본적인 데이터 바인딩은 단방향 으로만 작동하는것이었습니다. 즉 뷰가 바인딩한 객체의 데이터 변화는 옵저빙해 감지하는데 바인딩한 객체는 뷰의 데이터 변화를 감지하지 못했습니다.
  
그렇기때문에 뷰의 데이터 변화도 감지못해 객체의 데이터가 변화하지 않은것이었습니다. 그러므로 양방향으로 바꿔줘야했습니다.  
바꿔주는 방법은 android.text = "@{viewmodel.secondName}" 에서 android.text = "@={viewmodel.secondName}"으로 바꿔주면 됩니다.  
그리고 불변성을 가지고있는 데이터 타입이면 mutable으로 바꿔줘야됩니다.  
블로그 정리  
https://hegunhee.tistory.com/23  
  
## BindingAdapter  
[bindingAdapter 사용법](https://hegunhee.tistory.com/25)  
## 기타 추가사항  
RecyclerView의 데이터를 변경할때 최소한의 데이터에  
대해서만 갱신하기위해 DiffUtil을 사용하였습니다.
