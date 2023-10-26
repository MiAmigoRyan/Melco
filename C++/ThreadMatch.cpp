#include <iostream>
#include <vector>
#include <string>
#include <cmath>
#include <limits>

struct Thread {
    std::string manufacturer;
    std::string name;
    int code;
    std::vector<double> color;

    // Constructor
    Thread(std::string manufacturer, std::string name, int code, std::vector<double> color)
        : manufacturer(manufacturer), name(name), code(code), color(color) {}

    // Function for calculating the difference between RGB colors
    double difference(const Thread &other) const {
        double sumOfSquares = 0;
        for (int i = 0; i < 3; i++) {
            sumOfSquares += (color[i] - other.color[i]) * (color[i] - other.color[i]);
        }
        return std::sqrt(sumOfSquares);
    }
};


// F U N C T I O N   P R O T O T Y P E S
std::vector<Thread> initMachineThreads();
Thread getUserInput();
bool matchPreference();
void matchResult(int matchIndex);
int findMatchingThread(const Thread &designThread, bool exactMatch, const std::vector<Thread> &machineThreads);

int main()
{
    std::cout << "PROBLEM 1: Thread Matching" << std::endl;
    // Init vector of existing threads
    std::vector<Thread> machineThreads = initMachineThreads();
    // Required exact match preference
    bool exactMatch = matchPreference();
    // Collect user input for the design thread
    Thread designThread = getUserInput();
    // Match designThread to machineThread
    int matchIndex = findMatchingThread(designThread, exactMatch, machineThreads);
    // Display match result
    matchResult(matchIndex);

    return 0;
}
// Function for collecting user request for exact match
bool matchPreference()
{
    bool exactMatch = 0;
    std::cout << "Exact match? (1 for true, 0 for false)";
    std::cin >> exactMatch;
    return exactMatch;
}

// Function for response based on matchIndex
void matchResult(int matchIndex)
{
    if (matchIndex != -1)
    {
        std::cout << "Match found at index: " << matchIndex << std::endl;
    }
    else
    {
        std::cerr << "No match available, check inputs" << std::endl;
    }
}

// Create an existing vector of threads on machine
std::vector<Thread> initMachineThreads()
{
    return {
        Thread("ThreadCo", "Fire Engine", 1234, {1.0, 0.0, 0.0}),
        Thread("ThreadCo", "Midnight", 5678, {0.0, 0.0, 1.0}),
        Thread("EmbroideryInc", "Sunlight", 900, {0.5, 0.5, 0.0})};
}

// Collect user input for values
Thread getUserInput()
{
    std::string manufacturer, name;
    int code;
    double red, green, blue;

    std::cout << "Manufacturer: ";
    std::cin >> manufacturer;

    std::cout << "Name: ";
    std::cin >> name;

    std::cout << "Code: ";
    std::cin >> code;

    std::cout << "Enter RGB values";
    std::cout << "Red (0.0-1.0): ";
    std::cin >> red;

    std::cout << "Green (0.0-1.0): ";
    std::cin >> green;

    std::cout << "Blue (0.0-1.0): ";
    std::cin >> blue;

    std::vector<double> color = {red, green, blue};

    return Thread(manufacturer, name, code, color);
}

int findMatchingThread(const Thread &designThread, bool exactMatch, const std::vector<Thread> &machineThreads)
{
    int matchIndex = -1;
    double minDifference = std::numeric_limits<double>::max();

    for (size_t i = 0; i < machineThreads.size(); ++i)
    {
        const Thread &machineThread = machineThreads[i];
        bool isExactMatch = designThread.manufacturer == machineThread.manufacturer &&
                            designThread.name == machineThread.name &&
                            designThread.code == machineThread.code;

        double difference = designThread.difference(machineThread);
        // Refactored logic to only compute the difference if not exactMatch
         if (!exactMatch)
        {
            double difference = designThread.difference(machineThread);
            if (difference < minDifference)
            {
                matchIndex = i;
                minDifference = difference;
            }
        }
        else if (isExactMatch)
        {
            matchIndex = i;
            break;
        }
    }
    return matchIndex;
}
