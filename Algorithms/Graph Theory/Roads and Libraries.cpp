#include<bits/stdc++.h>
using namespace std;
#define all(v)                  v.begin(), v.end()
#define rall(v)                 v.rbegin(), v.rend()
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
const int N = 1e5+10;

/*************User defined function*************/
vector<int> g[N];
bool used[N];
int cnt = 0;

void dfs(int u) {
    cnt++;
    used[u] = true;
    for(int v: g[u]) {
        if(!used[v]) dfs(v);
    }
}

void solve() {
    ll n, m, cl, cr;
    cin >> n >> m >> cl >> cr;

    rep(i, 1, m) {
        int u, v;
        cin >> u >> v;
        g[u].pub(v);
        g[v].pub(u);
    }

    if(cl <= cr) {
        print(n*cl);
    } else {
        ll ans = 0;
        rep(i, 1, n) {
            if(!used[i]) {
                cnt = 0;
                dfs(i);
                ans += cl;
                ans += ((cnt-1)*cr);
            }
        }
        print(ans);
    }

    rep(i, 0, N-1) {
        g[i].clear();
        used[i] = false;
    }
}

/*************main function*************/
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    #endif 

    int test = 1;
    cin >> test;
    while(test-- > 0) {
        solve();
    }

    return 0;
}    
