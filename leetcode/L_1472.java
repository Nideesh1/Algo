class BrowserHistory {
    Stack<String> history;
    Stack<String> forward;
    public BrowserHistory(String homepage) {
        history = new Stack<>();
        forward = new Stack<>();
        history.push(homepage);
    }
    
    public void visit(String url) {
        history.push(url);
        forward.clear();
    }
    
    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            forward.push(history.pop());
            steps--;
        }
        return history.peek();
    }
    
    public String forward(int steps) {
        while (steps > 0 && forward.size() > 0) {
            history.push(forward.pop());
            steps--;
        }
        return history.peek();
    }
}

class BrowserHistory {
    int cur = 0;
    List<String> list;
    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
    }
    
    public void visit(String url) {
        list.subList(cur + 1, list.size()).clear();
        list.add(url);
        cur++;
    }
    
    public String back(int steps) {
        cur = Math.max(0, cur - steps);
        return list.get(cur);
    }
    
    public String forward(int steps) {
        cur = Math.min(list.size() - 1, cur + steps);
        return list.get(cur);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
