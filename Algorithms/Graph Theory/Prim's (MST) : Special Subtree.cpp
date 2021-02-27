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
const int N = 3e3+10;

/*************User defined function*************/
vector<pii> g[N];
bool used[N];

struct cmp { 
    constexpr bool operator()(pii const& a, pii const& b) 
    const noexcept { 
        return a.second > b.second; 
    } 
}; 

void solve() {
    int n, m;
    cin >> n >> m;
    
    rep(i, 1, m) {
        int u, v, w;
        cin >> u >> v >> w;
        g[u].pub({v, w});
        g[v].pub({u, w});
    }

    int s; cin >> s;

    ll ans = 0;
    pqueue<pii, vector<pii>, cmp> q;
    q.push({s, 0});
    while(!q.empty()) {
        auto u = q.top();
        q.pop();

        if(!used[u.first]) ans += u.second;

        used[u.first] = true;
        for(pii v: g[u.first]) {
            if(!used[v.first]) q.push(v);
        }
    }
    
    print(ans);
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
    //cin >> test;
    while(test-- > 0) {
        solve();
    }

    return 0;
}    
