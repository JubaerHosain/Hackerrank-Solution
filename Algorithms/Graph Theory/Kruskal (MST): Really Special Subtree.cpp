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
const int N = 3e3+10;

/*************Disjoint set*************/
vector<int> parent(N, -1);

int find(int key){
    if(parent[key] == -1)
        return key;     
    return find(parent[key]);
}
        
void merge(int x, int y){
    int xset = find(x);
    int yset = find(y);  
    parent[yset] = xset;
}

/*************User defined function*************/
int cmp(pair<int, pii> a, pair<int, pii> b) {
    return a.second.second < b.second.second;
}

void solve() {
    int n, m;
    cin >> n >> m;

    vector<pair<int, pii>> edges;
    while(m--) {
        int u, v, w;
        cin >> u >> v >> w;
        edges.pub({u, {v, w}});
    }

    sort(all(edges), cmp);
    
    ll ans = 0;
    for(auto edge: edges) {
        int u = edge.first;
        int v = edge.second.first;
        int w = edge.second.second;

        if(find(u) != find(v)) {
            merge(u, v);
            ans += w;
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
