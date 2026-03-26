class Solution {
    public int minInsertions(String s) {
        /* for every left two right. -> ( )) that 2 right paranthesis should be after 
        the left.*/
        
          StringBuilder ii = new StringBuilder(s);
        //   System.out.println(ii);
          int fin_ans = 0;
          Stack<Character> open = new Stack<>();
          
          for (int i = 0;i < ii.length(); i++) {
            // if (ii.charAt(i) == '(') {
            //     open.push(ii.charAt(i));
            //     ii.setCharAt(i, ' ');
            // }
            // else if (!open.isEmpty() && ii.charAt(i) == ')') {
            //     // int count = 
            //     if (i < ii.length() - 1 && ii.charAt(i + 1) == ')') {
            //         open.pop();
            //         ii.setCharAt(i, ' ');
            //         ii.setCharAt(i + 1, ' ');
            //     }
            //     else {
            //         open.pop();
            //         ii.setCharAt(i, ' ');
            //         fin_ans++;
            //     }
            // }
            // else continue;
            if (ii.charAt(i) == '(') {
                open.push('(');
            }
            else if (ii.charAt(i) == ')') {
                
                // CASE 1: we have a matching '('
                if (!open.isEmpty()) {
                    
                    // try to form "))"
                    if (i + 1 < ii.length() && ii.charAt(i + 1) == ')') {
                        open.pop();
                        i++; // consume next ')'
                    } else {
                        // only one ')', need one more ')'
                        open.pop();
                        fin_ans++; // insert one ')'
                    }
                } 
                else {
                    // CASE 2: no matching '(' → need to insert one
                    fin_ans++; // insert '('
                    
                    // now handle current ')'
                    if (i + 1 < ii.length() && ii.charAt(i + 1) == ')') {
                        i++; // consume pair
                    } else {
                        fin_ans++; // need one more ')'
                    }
                }
            }
          }
          
          while (!open.isEmpty()) {
            open.pop();
            fin_ans += 2;
          }
          
        //   System.out.println(ii);
          
        // int c = 0;
          
        // for (int i = 0; i < ii.length(); i++) if (ii.charAt(i) == ')') c++;
        // // System.out.println(c);
        
        // int add = (c / 2) + ((c % 2 == 0) ? 0 : 2);
        
          
          return fin_ans;
    }
}
