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
typedef pair<ll, ll> pii;
typedef vector<vector<int>> vii;
const int p = 1e9+7;
const double pi = 3.141592653589793;
const int eps = 1e-9;
const int inf = INT_MAX;
const int N = 5e4+5;

/*************User defined function*************/
vector<pii> g[N];                               //{v, w}
vector<ll> dist(N, inf);
bool used[N];

void dijkstra(int u) {
    pqueue<pii, vector<pii>, greater<pii>> pq;  //{w, v}
    pq.push({0, u});
    dist[u] = 0;

    while(!pq.empty()) {
        u = pq.top().second;
        pq.pop();

        if(used[u]) continue;
        used[u] = true;

        for(auto a: g[u]) {
            ll v = a.first;
            ll w = a.second-dist[u];
            if(w < 0) w = 0;
            if(dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                pq.push({dist[v], v});
            }
        }
    }
}

void solve() {
    int n, m;
    cin >> n >> m;

    while(m--) {
        int u, v, w;
        cin >> u >> v >> w;
        g[u].pub({v, w});
        g[v].pub({u, w});
    }

    dijkstra(1);

    if(dist[n] == inf) {
        print("NO PATH EXISTS");
    }
    else {
        print(dist[n]);
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

    cout << fixed << showpoint;
    cout << setprecision(10);

    int test = 1;
    //cin >> test;
    while(test-- > 0) {
        solve();
    }

    return 0;
}    
