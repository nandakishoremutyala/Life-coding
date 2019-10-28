# Life-coding
Solve one problem everyday. 

All of my daily problem solving lives in this repo. Some of the wrong 
attempt is also here. If you follow this repo, make sure you run the code and try
with test cases. 
# Amazon Leadership interview details
* https://interviewgenie.com/blog-1/category/Amazon+interviews
## Resources
* Cracking the coding interview book
* https://www.geeksforgeeks.org/
* https://www.interviewbit.com/practice/
* https://start.interviewing.io/dashboard/interviewee
* https://leetcode.com/
* https://www.coursera.org/
* https://code.google.com/codejam/kickstart/
* https://www.pramp.com/dashboard
* https://www.youtube.com/channel/UCWSYAntBbdd2SLYUqPIxo0w
* https://www.byte-by-byte.com/
* https://www.dailycodingproblem.com/
* https://coderbyte.com/
* https://www.interviewcake.com
* https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/
* https://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/
## Helper materials: 

Tree:
    
   * Segment Tree: https://www.youtube.com/watch?v=Oq2E2yGadnU
   * AVL Tree: https://www.youtube.com/watch?v=-9sHvAnLN_w
   
## Dynamic Programming   
* Understanding Longest common subsequence: https://www.youtube.com/watch?v=43P0xZp3FU4
   
## Understanding SSTable

    * https://www.igvita.com/2012/02/06/sstable-and-log-structured-storage-leveldb/
    * https://hackernoon.com/fundamentals-of-system-design-part-3-8da61773a631
   
## Java Code Beauty: 

Composition Function: http://www.deadcoderising.com/2015-09-07-java-8-functional-composition-using-compose-and-andthen/

### Quick Notes   
#### Counting character frequency in a string. 

 ```
 String s="HelloWorld";
 Map<Character, Long> map = t.chars() //converting int stream
                   .mapToObj(c -> (char) c)//int stream to character stream
                   .collect(Collectors.groupingBy(Function.identity(),// collect by group
                           Collectors.counting()));
           System.out.println(map);
  ```
 
      
#### Best way to find mid point. 
 ``` 
 M=start+(end-start)/2;//overflow error free

```

#### Sort an int array in descending order
```$xslt
int[] sorted = IntStream.of(inputArray)
        .boxed()
        .sorted(Comparator.reverseOrder())
        .mapToInt(i -> i)
        .toArray();
```
  
#### Iterating over map 
  ```
 map.entrySet().stream().forEach(entry->{
            System.out.println("Key: "+entry.getKey()+"value: "+entry.getValue());
        });
```
    
#### String counting in java 8
```$xslt
        String[] strings=new String[]{"hello","world","hello"};
        List<String> list=Arrays.asList(strings);
        Map<String, Long> map1=         list.stream().collect(groupingBy(identity(), counting()));

```        
Alternatively,
```
HashMap<String,Long> map= (HashMap<String, Long>) Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
```


#### Sort list of object based on property
```$xslt
 private static class Inerval {
        int start;
        int end;

        public Inerval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
     ArrayList<Inerval> list=new ArrayList<>();
     list.add(new Inerval(1,3));
     list.add(new Inerval(5,8));
     list.add(new Inerval(4,10));
     list.add(new Inerval(20,25));
     list.sort(Comparator.comparingInt(v -> v.start));
     list.stream().forEach(interval -> {
                System.out.println(interval.start+"->"+interval.end);
      });

# How to sort from largest to smallest

      list.sort((i1, i2) -> {
                 if (i2.start > i1.start) return 1;//we want next bigger element first
                 else if (i1.start > i2.start) return -1;
                 else return 0;
     
             });
     
      list.stream().forEach(interval -> {
          System.out.println(interval.start + "->" + interval.end);
      });
```
#### PriorityQueue with custom comparator
```$xslt
 PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(node -> node.val));
```           

#### Best Way to understand backtracking
* https://www.youtube.com/watch?v=78t_yHuGg-0
* https://www.youtube.com/watch?v=5v6zdfkImms
* https://www.youtube.com/watch?v=78t_yHuGg-0
* https://www.youtube.com/watch?v=HvGkzDT2ffI&t=1492s

#### Best way of understanding Huffman Encoding
* https://www.youtube.com/watch?v=ikswC-irwY8&list=PLnfg8b9vdpLn9exZweTJx44CII1bYczuk&index=42