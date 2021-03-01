#include<bits/stdc++.h>
using namespace std;
#define all(v)                  v.begin(), v.end()
#define des()                   greater<>()
#define pqueue                  priority_queue
#define pub                     push_back
#define pob                     pop_back  
#define endl                    '\n'        //in interactive problem should not use this
#define print_array(v, a, n)    for(ll i = a; i <= n; i++) { cout << v[i] << " "; } cout << endl;
#define print(var)              cout << var << endl;
typedef long long int ll;
typedef long double ld;
typedef pair<int, int> pii;
typedef vector<vector<int>> vii;
const double pi = 3.141592653589793;
const int inf = INT_MAX;
const int N = 2e5+5;

/*************User defined function*************/
void floyd_warshal(int n, vii &dist) {
    for(int k = 1; k <= n; k++)
    for(int i = 1; i <= n; i++)
    for(int j = 1; j <= n; j++)
    if(dist[i][k] != inf && dist[k][j] != inf) 
    dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j]);
}

void solve() {
    int n, m;
    cin >> n >> m;

    vii dist(n+1, vector<int>(n+1, inf));
    for(int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        dist[u][v] = w;
    }

    floyd_warshal(n, dist);

    int q;
    cin >> q;
    while(q--) {
        int u, v;
        cin >> u >> v;
        if(u == v) dist[u][v] = 0;
        if(dist[u][v] == inf) dist[u][v] = -1;
        print(dist[u][v]);
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
    cout << setprecision(9);

    int test = 1;
    //cin >> test;
    while(test-- > 0) {
        solve();
    }

    return 0;
}    
