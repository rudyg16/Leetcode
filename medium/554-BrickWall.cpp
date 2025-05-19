class Solution
{
public:
    int leastBricks(vector<vector<int>> &wall)
    {
        unordered_map<long long, int> rowLines;
        for (auto &row : wall)
        {
            long long currX = 0; // Keep track of x position when going through bricks
            for (int i = 0; i < row.size() - 1; i++)
            {
                currX += row[i];
                rowLines[currX]++; // if brick ends at this x-value,increment map value for it
            }
        }
        int maxVal = 0;
        for (const auto &pair : rowLines)
        {
            if (pair.second > maxVal)
            {
                maxVal = pair.second;
            }
        }
        int minRows = wall.size() - maxVal;
        return minRows;
    }
};