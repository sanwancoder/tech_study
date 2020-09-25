## Java8目的
```
Java8最主要的就是给我们编程的过程带来了很多便利，不仅仅是代码量少。更多的还是让程序更简洁，减少代码冗余。
```
## 1、接口的默认方法

## 2、Stream 接口

- [Java 8 Stream](https://www.runoob.com/java/java8-streams.html)
    - foreach
    - map 
    - filter
    - limit
## 3、Optional
## 4、Date/time API的改进
## Lambda表达式
 
 - Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据

- 最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示：

```
  Arrays.asList( 1, 2, 3 ).forEach( e -> System.out.println( e ) );
```
- Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）：

```
  String str = ",";			//等价于：final String str = ",";
  Arrays.asList( "a", "b", "c" ).forEach( 
      ( String e ) -> System.out.print( e + str ) );	
```

- Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句:

```
  List<Integer> list = Arrays.asList( 4, 2, 1,3);
  list.sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
  list.forEach(e->System.out.println(e));
```

[参考文章 Xchunguang/java8](https://github.com/Xchunguang/java8)



----
----
----

# Lambda表达式


- Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据

- 最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示：

		Arrays.asList( 1, 2, 3 ).forEach( e -> System.out.println( e ) );

- Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）：

		String str = ",";			//等价于：final String str = ",";
		Arrays.asList( "a", "b", "c" ).forEach( 
		    ( String e ) -> System.out.print( e + str ) );	
		    


- Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句:

		List<Integer> list = Arrays.asList( 4, 2, 1,3);
		list.sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
		list.forEach(e->System.out.println(e));	
					
			
# 函数式接口

- 如何使现有的函数友好地支持lambda，java8采取了增加函数式接口的概念。
- 函数式接口就是一个只有一个方法的普通接口，可以隐式的转换成lambda表达式，除了特殊方法：默认方法，静态方法以及继承自Object类的一些方法（toString(),equels()等）
- 在使用中，函数式接口容易出错，如果接口中被定义了另一个方法，那么接口将不再是函数式接口，导致编译失败。为此Java8新增注解@FunctionalInterface。注意default默认方法和静态方法不会影响函数式接口。

		@FunctionalInterface
		public interface Runnable {
		    public abstract void run();
		}

- java8新增默认方法和静态方法扩展接口的声明。

		public interface Convert {

			//可以包含静态方法
			public static void hasStaticMethod(){
				System.out.println("包含静态方法");
			}
			
			default void hasDefaultMethod(){
				System.out.println("包含默认方法");
			}
		}
		
- 函数式接口示例

		@FunctionalInterface
		public interface Convert<F,T> {
		
			T convert(F from);
			
			//可以包含静态方法
			public static void hasStaticMethod(){
				System.out.println("包含静态方法");
			}
			
			default void hasDefaultMethod(){
				System.out.println("包含默认方法");
			}
		}
		
		public class ConvertMain {
		public static void main(String[] args) {
	
			Convert<String, Integer> converter = (from) -> Integer.valueOf(from);
			Integer converted = converter.convert("123");
			System.out.println(converted);
			converter.hasDefaultMethod();
			Convert.hasStaticMethod();
	
			
			// Function<T, R> -T作为输入，返回的R作为输出
			Function<String,String> function = (x) -> {System.out.print(x+": ");return "Function";};
			System.out.println(function.apply("hello world"));
	
			//Predicate<T> -T作为输入，返回的boolean值作为输出
			Predicate<String> pre = (x) ->{System.out.print(x);return false;};
			System.out.println(": "+pre.test("hello World"));
	
			//Consumer<T> - T作为输入，执行某种动作但没有返回值
			Consumer<String> con = (x) -> {System.out.println(x);};
			con.accept("hello world");
	
			//Supplier<T> - 没有任何输入，返回T
			Supplier<String> supp = () -> {return "Supplier";};
			System.out.println(supp.get());
	
	
			//BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
			BinaryOperator<String> bina = (x,y) ->{System.out.print(x+" "+y);return "BinaryOperator";};
			System.out.println("  "+bina.apply("hello ","world"));
			
		}
	}
				
						
			
# 方法引用（::）

- 以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用

- 第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数。

		final Car car = Car.create( Car::new );
		final List< Car > cars = Arrays.asList( car );

- 第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。

		cars.forEach( Car::collide );
		
- 第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。

		cars.forEach( Car::repair );
		
- 最后，第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数

		final Car police = Car.create( Car::new );
		cars.forEach( police::follow );		
		
		
		private void sort(){
		    List<Commodity> commodities=new ArrayList<>();
		    //java 8之前
		    commodities.sort(new Comparator<Commodity>() {
		    @Override
		    public int compare(Commodity o1, Commodity o2) {
		            return o1.getPrice()-o2.getPrice();
		        }
		    });
		    //java 8 lambda的写法
		    commodities.sort((Commodity o1,Commodity o2)->o1.getPrice()-o2.getPrice());
		    //java 8 方法应用的写法
		    commodities.sort(Comparator.comparing(Commodity::getPrice));
		}

	
# 重复注解

- java5开始引用注解机制，然而相同注解在同样的地方只能声明一次，java8引入重复注解。

- 重复注解机制本身必须用@Repeatable注解。事实上是编译器技巧的改变
	
	
# 更好的类型推断

- Java 8在类型推测方面有了很大的提高。在很多情况下，编译器可以推测出确定的参数类型，这样就能使代码更整洁。

		public class Value< T > {
		    public static< T > T defaultValue() { 
		        return null; 
		    }
		     
		    public T getOrDefault( T value, T defaultValue ) {
		        return ( value != null ) ? value : defaultValue;
		    }
		}
		
		public class TypeInference {
		    public static void main(String[] args) {
		        final Value< String > value = new Value<>();
		        value.getOrDefault( "22", Value.defaultValue() );
		    }
		}

# 扩展注解的支持

- Java 8扩展了注解的上下文。现在几乎可以为任何东西添加注解：局部变量、泛型类、父类与接口的实现，方法的异常也可以添加注解。

		public class Annotations {
		    @Retention( RetentionPolicy.RUNTIME )
		    @Target( { ElementType.TYPE_USE, ElementType.TYPE_PARAMETER } )
		    public @interface NonEmpty {        
		    }
		         
		    public static class Holder< @NonEmpty T > extends @NonEmpty Object {
		        public void method() throws @NonEmpty Exception {           
		        }
		    }
		         
		    @SuppressWarnings( "unused" )
		    public static void main(String[] args) {
		        final Holder< String > holder = new @NonEmpty Holder< String >();       
		        @NonEmpty Collection< @NonEmpty String > strings = new ArrayList<>();       
		    }
		}
		
	ElementType.TYPE_USE和ElementType.TYPE_PARAMETER是两个新添加的用于描述适当的注解上下文的元素类型。
		
# Optional

- 新增类库，为解决java中常见的空指针异常导致程序无法正常运行

- Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。

		//允许为空值，当值为空时也不会报错
		Optional< String > name = Optional.ofNullable( null );
		System.out.println( "name是否有值 " + name.isPresent() );        
		System.out.println( "如果名称为空: " + name.orElseGet( () -> "代替名称" ) ); 
		System.out.println( name.map( s -> "名称为： " + s  ).orElse( "名称为空" ) );
		
		//不允许为空值，当值为空时会报错
		Optional< String > firstName = Optional.of( "name" );
		System.out.println( "firstName是否有值 " + firstName.isPresent() );        
		System.out.println( "如果名称为空: " + firstName.orElseGet( () -> "代替名称" ) ); 
		System.out.println( firstName.map( s -> "名称为： " + s  ).orElse( "名称为空" ) );
		
	Optional<a href="https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html">文档</a>
		
# Stream
	
-  把真正的函数式编程风格引入到Java中。简化了集合框架的处理。

		public class Streams  {
		    private enum Status {
		        OPEN, CLOSED
		    };
		     
		    private static final class Task {
		        private final Status status;
		        private final Integer points;
		 
		        Task( final Status status, final Integer points ) {
		            this.status = status;
		            this.points = points;
		        }
		         
		        public Integer getPoints() {
		            return points;
		        }
		         
		        public Status getStatus() {
		            return status;
		        }
		         
		        @Override
		        public String toString() {
		            return String.format( "[%s, %d]", status, points );
		        }
		    }
		}
		
		//task集合
		final Collection< Task > tasks = Arrays.asList(
		    new Task( Status.OPEN, 5 ),
		    new Task( Status.OPEN, 13 ),
		    new Task( Status.CLOSED, 8 ) 
		);
		
		
		//所有状态为OPEN的任务一共有多少分数
		final long totalPointsOfOpenTasks = tasks
		    .stream()
		    .filter( task -> task.getStatus() == Status.OPEN )
		    .mapToInt( Task::getPoints )
		    .sum();
		         
		System.out.println( "Total points: " + totalPointsOfOpenTasks );
	
	首先，task集合被转换化为stream。然后，filter操作过滤掉状态为CLOSED的task。下一步，mapToInt操作通过Task::getPoints方法调用把Task的stream转化为Integer的stream。最后，用sum函数把所有的分数加起来，得到最终的结果。
	
	stream注意事项：<a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#StreamOps">Ops</a>	
	
- .stream操作被分成了中间操作与最终操作，中间操作返回一个新的stream对象。中间操作总是采用惰性求值方式，运行一个像filter这样的中间操作实际上没有进行任何过滤，相反它在遍历元素时会产生了一个新的stream对象，这个新的stream对象包含原始stream中符合给定谓词的所有元素。

- 像forEach、sum这样的最终操作可能直接遍历stream，产生一个结果。当最终操作执行结束之后，stream管道被认为已经被消耗了，不能再使用。在大多数情况下，最终操作都是采用及早求值方式，及早完成底层数据源的遍历 

- stream另一个有价值的地方是能够原生支持并行处理

		final double totalPoints = tasks
		   .stream()
		   .parallel()
		   .map( task -> task.getPoints() ) // or map( Task::getPoints ) 
		   .reduce( 0, Integer::sum );
		     
		System.out.println( "Total points (all tasks): " + totalPoints );

		
		//按照某种准则来对集合中的元素进行分组。
		final Map< Status, List< Task > > map = tasks
		    .stream()
		    .collect( Collectors.groupingBy( Task::getStatus ) );
		System.out.println( map );
		
		//计算整个集合中每个task分数（或权重）的平均值来结束task
		final Collection< String > result = tasks
		    .stream()                                        // Stream< String >
		    .mapToInt( Task::getPoints )                     // IntStream
		    .asLongStream()                                  // LongStream
		    .mapToDouble( points -> points / totalPoints )   // DoubleStream
		    .boxed()                                         // Stream< Double >
		    .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
		    .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
		    .collect( Collectors.toList() );                 // List< String > 
		         
		System.out.println( result );
		
- Stream API不仅仅处理Java集合框架。像从文本文件中逐行读取数据这样典型的I/O操作也很适合用Stream API来处理

		final Path path = new File( filename ).toPath();
		try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
		    lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
		}
		
	对一个stream对象调用onClose方法会返回一个在原有功能基础上新增了关闭功能的stream对象，当对stream对象调用close()方法时，与关闭相关的处理器就会执行。
		
# Date/Time API (JSR 310)

- Joda-Time——一个可替换标准日期/时间处理且功能非常强大的Java API

- <a href="https://www.javacodegeeks.com/2014/03/whats-new-in-java-8-date-api.html">新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作</a>

- Clock类，它通过指定一个时区，然后就可以获取到当前的时刻，日期与时间。Clock可以替换System.currentTimeMillis()与TimeZone.getDefault()。
	
		final Clock clock = Clock.systemUTC();
		System.out.println( clock.instant() );
		System.out.println( clock.millis() );
		
- LocaleDate与LocalTime。LocaleDate只持有ISO-8601格式且无时区信息的日期部分。相应的，LocaleTime只持有ISO-8601格式且无时区信息的时间部分。LocaleDate与LocalTime都可以从Clock中得到

		final LocalDate date = LocalDate.now();
		final LocalDate dateFromClock = LocalDate.now( clock );
		         
		System.out.println( date );
		System.out.println( dateFromClock );
		         
		// Get the local date and local time
		final LocalTime time = LocalTime.now();
		final LocalTime timeFromClock = LocalTime.now( clock );
		         
		System.out.println( time );
		System.out.println( timeFromClock );
		
- LocaleDateTime把LocaleDate与LocaleTime的功能合并起来，它持有的是ISO-8601格式无时区信息的日期与时间。

		final LocalDateTime datetime = LocalDateTime.now();
		final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );
		         
		System.out.println( datetime );
		System.out.println( datetimeFromClock );
		
- 如果你需要特定时区的日期/时间，可以使用ZonedDateTime。它持有ISO-8601格式具具有时区信息的日期与时间

		final ZonedDateTime zonedDatetime = ZonedDateTime.now();
		final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
		final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles" ) );
		         
		System.out.println( zonedDatetime );
		System.out.println( zonedDatetimeFromClock );
		System.out.println( zonedDatetimeFromZone );
		
		
- Duration类：Duration使计算两个日期间的差变的十分简单。

		final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
		final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
		 
		final Duration duration = Duration.between( from, to );
		System.out.println( "Duration in days: " + duration.toDays() );
		System.out.println( "Duration in hours: " + duration.toHours() );
			
# JavaScript引擎Nashorn

- Nashorn，一个新的JavaScript引擎随着Java 8一起公诸于世，它允许在JVM上开发运行某些JavaScript应用。Nashorn就是javax.script.ScriptEngine的另一种实现，并且它们俩遵循相同的规则，允许Java与JavaScript相互调用。

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		         
		System.out.println( engine.getClass().getName() );
		System.out.println( "Result:" + engine.eval( "function f() { return 1; }; f() + 1;" ) );
			
			
# Base64：Java 8中，Base64编码已经成为Java类库的标准。
	
 
			import java.nio.charset.StandardCharsets;
			import java.util.Base64;
			 
			public class Base64Test {
			    public static void main(String[] args) {
			        final String text = "Base64 finally in Java 8!";
			         
			        final String encoded = Base64
			            .getEncoder()
			            .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
			        System.out.println( encoded );
			         
			        final String decoded = new String( 
			            Base64.getDecoder().decode( encoded ),
			            StandardCharsets.UTF_8 );
			        System.out.println( decoded );
			    }
			}
			
		Base64类同时还提供了对URL、MIME友好的编码器与解码器（Base64.getUrlEncoder() / Base64.getUrlDecoder(), Base64.getMimeEncoder() / Base64.getMimeDecoder()）。
			
# 并行（parallel）数组

- Java 8增加了大量的新方法来对数组进行并行处理。可以说，最重要的是parallelSort()方法，因为它可以在多核机器上极大提高数组排序的速度。


			import java.util.Arrays;
			import java.util.concurrent.ThreadLocalRandom;
			 
			public class ParallelArrays {
			    public static void main( String[] args ) {
			        long[] arrayOfLong = new long [ 20000 ];        
			         
			        Arrays.parallelSetAll( arrayOfLong, 
			            index -> ThreadLocalRandom.current().nextInt( 1000000 ) );
			        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
			            i -> System.out.print( i + " " ) );
			        System.out.println();
			         
			        Arrays.parallelSort( arrayOfLong );     
			        Arrays.stream( arrayOfLong ).limit( 10 ).forEach( 
			            i -> System.out.print( i + " " ) );
			        System.out.println();
			    }
			}
			
		上面的代码片段使用了parallelSetAll()方法来对一个有20000个元素的数组进行随机赋值。然后，调用parallelSort方法。这个程序首先打印出前10个元素的值，之后对整个数组排序。
			
			
# 并发（Concurrency）

- 在新增Stream机制与lambda的基础之上，在java.util.concurrent.ConcurrentHashMap中加入了一些新方法来支持聚集操作。同时也在java.util.concurrent.ForkJoinPool类中加入了一些新方法来支持共有资源池（common pool）

- 新增的java.util.concurrent.locks.StampedLock类提供一直基于容量的锁，这种锁有三个模型来控制读写操作（它被认为是不太有名的java.util.concurrent.locks.ReadWriteLock类的替代者）。

	在java.util.concurrent.atomic包中还增加了下面这些类：
	
		DoubleAccumulator
		DoubleAdder
		LongAccumulator
		LongAdder
		
# 类依赖分析器jdeps

- jdeps是一个很有用的命令行工具。它可以显示Java类的包级别或类级别的依赖。它接受一个.class文件，一个目录，或者一个jar文件作为输入。jdeps默认把结果输出到系统输出（控制台）上。

		jdeps org.springframework.core-3.0.5.RELEASE.jar	
			
# Java虚拟机（JVM）的新特性

- PermGen空间被移除了，取而代之的是Metaspace（JEP 122）。JVM选项-XX:PermSize与-XX:MaxPermSize分别被-XX:MetaSpaceSize与-XX:MaxMetaspaceSize所代替。
		
参考：<a href="https://www.javacodegeeks.com/2014/05/java-8-features-tutorial.html">Java 8 Features Tutorial </a>

	
