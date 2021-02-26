import java.util.ArrayDeque;
import java.util.Scanner;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if(ch=='['||ch=='('||ch=='{')
                {
                    stack.push(ch);
                    continue;
                }
                if(ch==']'&&!stack.isEmpty()&&stack.peek()=='[')
                {
                    stack.pop();
                    continue;
                }
                if(ch==')'&&!stack.isEmpty()&&stack.peek()=='(')
                {
                        stack.pop();
                        continue;
                }
                if(ch=='}'&&!stack.isEmpty()&&stack.peek()=='{')
                {
                    stack.pop();
                    continue;
                }
                if(ch==']'||ch==')'||ch=='}')
                {
                    stack.push(ch);
                    break;
                }
            }
            System.out.println(stack.isEmpty());
		}
		
	}
}



