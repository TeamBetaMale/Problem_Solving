#include <iostream>

using namespace std;

int main() {
  int counter[26];
  fill_n(counter, 26, -1);

  string s;
  cin >> s;

  for (int i = 0; i < s.length(); i++) {
    int ptr = s[i]-97;
    if (counter[ptr] == -1)
      counter[ptr] = i;
  }

  for (int i : counter)
    cout << i << " ";

  return 0;
}