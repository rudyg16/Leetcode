
class Solution
{
public:
    int addDigits(int num)
    {
        while (true)
        {
            string strnum = to_string(num);
            if (strnum.length() == 1)
            {
                return num;
            }
            int sum = 0;
            for (int i = 0; i < strnum.length(); i++)
            {
                char digit = strnum[i];
                int intdigit = digit - '0';
                sum += intdigit;
            }
            num = sum;
        }
    }
};