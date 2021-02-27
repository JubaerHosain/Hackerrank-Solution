#include<bits/stdc++.h>
using namespace std;
#define all(v)                  v.begin(), v.end()
#define rev(v)                  v.rbegin(), v.rend()
#define des()                   greater<int>()
#define rep(i, a, n)            for(ll i = a; i <= n; i++)  
#define rrep(i, n, a)           for(ll i = n; i >= a; i--)
#define pqueue                  priority_queue
#define umap                    unordered_map
#define uset                    unordered_set
#define pub                     push_back
#define pob                     pop_back  
#define endl                    '\n' //in interactive problem should not use this
#define println                 cout << endl
#define scan_array(v, a, n)     for(ll i = a; i <= n; i++) { cin >> v[i]; }
#define print_array(v, a, n)    for(ll i = a; i <= n; i++) { cout << v[i] << " "; } println;
#define print(var)              cout << var << endl;
typedef long long int ll;
typedef unsigned long long int ull;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;
const int p = 1e9+7;
const double pi = 3.141592653589793;
const int eps = 1e-9;
const int inf = INT_MAX;
const int N = 1e2+5;

/*************User defined function*************/
vector<int> g[N], edges(N), dist(N);
bool used[N];

void bfs(int u) {
    queue<int> q;
    q.push(u);
    used[u] = true;
    dist[u] = 0;
    while (!q.empty()) {
        u = q.front();
        q.pop();
        for(int v: g[u]) {
            if(!used[v]) {
                used[v] = true;
                dist[v] = 1+dist[u];
                q.push(v);
            }
        }
    }
    
}

void solve() {
    rep(i, 0, N-1) {
        g[i].clear();
        edges[i] = i;
        used[i] = false;
        dist[i] = -1;
    }

    int n, m;
    cin >> n;
    while(n--) {
        int l, r;
        cin >> l >> r;
        edges[l] = r;
    }

    cin >> m;
    while(m--) {
        int l, r;
        cin >> l >> r;
        edges[l] = r;
    }

    rep(u, 1, 100) {
        rep(i, 1, 6) {
            if(u+i <= 100 && edges[u] == u) {
                g[u].pub(edges[u+i]);
            }
        }
    }

    bfs(1);

    print(dist[100]);
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
    cout << setprecision(10);

    int test = 1;
    cin >> test;
    while(test-- > 0) {
        solve();
    }

    return 0;
}    
