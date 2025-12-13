class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        /* 
            -- We are given the number of users as "numberOfUsers".
            -- array called "events" of n x 3 -- meaning n-rows and 3-columns.
        */

        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        int[] mentions = new int[numberOfUsers];
        // Initially all the ussers are online ::
        // for (int i = 0; i < mentions.length; i++) mentions[i]++;
        Map<Integer, Integer> offline = new HashMap<>();
        // for (int i = 0; i < mentions.length; i++) offline.put(i, 0);
        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true);

        for (List<String> event : events) {
            int time = Integer.parseInt(event.get(1));
            for (int u = 0; u < numberOfUsers; u++) {
                if (!online[u] && offline.containsKey(u) && offline.get(u) <= time) {
                    online[u] = true;
                    offline.remove(u);
                }
            }

            if (event.get(0).equals("MESSAGE")) {
                if (event.get(2).equals("ALL")) {
                    for (int user = 0; user < mentions.length; user++) {
                        mentions[user]++;
                        // online[user] = true;
                    }
                }

                else if (event.get(2).equals("HERE")) {
                    for (int i = 0; i < mentions.length; i++) if (online[i]) mentions[i]++;
                }

                else {
                    String[] ids = event.get(2).split(" ");
                    for (String id : ids) {
                        int user = Integer.parseInt(id.substring(2));
                        mentions[user]++;
                    }
                }
            }
            else {
                offline.put(Integer.parseInt(event.get(2)), Integer.parseInt(event.get(1)) + 60);
                online[Integer.parseInt(event.get(2))] = false;
            }
        }
        return mentions;
    }
}
