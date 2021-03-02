#include<bits/stdc++.h>
using namespace std;
#define all(v)                  v.begin(), v.end()
#define des()                   greater<>()
#define pqueue                  priority_queue
#define endl                    '\n'        //in interactive problem should not use this
#define print_array(v, a, n)    for(ll i = a; i <= n; i++) { cout << v[i] << " "; } cout << endl;
#define print(var)              cout << var << endl;
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;
const int inf = INT_MAX;
const int N = 2e5+5;

/*************User defined function*************/
set<int> g[N], unused;
vector<int> dist(N);

void bfs(int s) {
    queue<int> q;
    q.push(s);
    unused.erase(s);
    dist[s] = 0;

    while(!q.empty()) {
        int u = q.front();
        q.pop();

        set<int> used;
        for(int v: unused) {
            if(g[u].count(v) == 0) {
                dist[v] = dist[u]+1;
                q.push(v);
                used.insert(v);
            }
        }

        for(int v: used) unused.erase(v);
    }
}

void solve() {
    int n, m;
    cin >> n >> m;

    unused.clear();
    for(int i = 1; i <= n; i++) {
        g[i].clear();
        unused.insert(i);
    }
        

    while(m--) {
        int u, v;
        cin >> u >> v;
        g[u].insert(v);
        g[v].insert(u);
    }

    int s;
    cin >> s;
    bfs(s);

    for(int i = 1; i <= n; i++) {
        if(i == s) continue;
        cout << dist[i] << " ";
    }
    cout << endl;
}

/*************main function*************/
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif 

    cout << fixed << showpoint;
    cout << setprecision(9);

    int test = 1;
    cin >> test;
    while(test-- > 0) {
        solve();
    }

    return 0;
}    
