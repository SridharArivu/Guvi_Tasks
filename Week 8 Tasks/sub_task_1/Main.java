import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{
  public static void main(String[] args) {
    Stream<String> names = Stream.of("abc","d","ef");
    List<String> upperCase =  names.map((txt) -> txt.toUpperCase())
                                    .collect(Collectors.toList());

    System.out.println("Given Input : \"abc\",\"d\",\"ef\" ");
    System.out.println("Modified Output using Map function :"+upperCase);
  }
}