"""state_info.py allows users to select from a list of choices
to display state data, also allows updating of state population"""

import sys
import matplotlib.image as mpimg
import matplotlib.pyplot as plt

def top_population_states():
    """Function to sort states by population and create bar graph
    of the top 5 most populated states, also prints the 5 states to console"""
    sorted_state = sorted(all_state_info.items(), key=lambda x: x[1][1], reverse=True)[:5]
    state_name = [sorted_state[x][0] for x in range(5)]
    population = [sorted_state[x][1][1] for x in range(5)]
    population_h_thousands = [x/1000000 for x in population]
    plt.figure(figsize=(10,15))
    plt.bar(state_name, population_h_thousands)
    plt.xlabel('States with the highest population')
    plt.ylabel('Population (Millions)')
    plt.suptitle('Top 5 states with highest population')
    plt.show()
    print('\nTop 5 state populations list:')
    for name, pop in zip(state_name, population):
        print('State: ' + str(name) + ' Population: ' + str(pop))
    input('Press enter to continue...\n')

def flower_image():
    """Function to look up flowers by state name and display their image"""
    state_get = input('Please enter State name:\n').title()
    flower = mpimg.imread('./flower_images/' + all_state_info[state_get][2] + '.jpg')
    print('State Capitol: ' + all_state_info[state_get][0] +
        ', Population: ' + f'{all_state_info[state_get][1]:,}' + ', Flower: '
        + all_state_info[state_get][2])
    plt.imshow(flower)
    plt.show()
    input('Press enter to continue...\n')

def pop_update():
    """Function to lookup state and update its population"""
    state_update = input('Please enter State name:\n').title()
    print('You have chosen to update ' + state_update + '\'s' +
        ' population, with current population: ' +
        f'{all_state_info[state_update][1]:,}')
    while True:
        new_population = int(input('Please enter ' + state_update +
            '\'s ' + 'new population (integers only, use underscores or do not separate):\n'))
        if new_population < 0:
            print('Population cannot be negative.')
            continue
        break
    all_state_info[state_update][1] = new_population
    print(state_update + '\'s' + ' new population is: '
        + f'{all_state_info[state_update][1]:,}')
    input('Press enter to continue...\n')

def abc_population():
    """Function to show all 50 states names and info in alphabetical order."""
    for key, value in sorted(all_state_info.items()):
        print(key + ' - State Capitol: ' + value[0] +
        ', Population: ' + f'{value[1]:,}' + ', Flower: '
        + value[2])
    input('Press enter to continue...\n')

# Dictionary for state info all_state_info[''] = state_info()
all_state_info = {}
all_state_info['Alabama'] = ['Montgomery', 4_887_680, 'Camellia']
all_state_info['Alaska'] = ['Juneau', 735_139, 'Alpine Forget Me Not']
all_state_info['Arizona'] = ['Phoenix', 7_158_020, 'Saguaro Cactus Blossom']
all_state_info['Arkansas'] = ['Little Rock', 3_009_730, 'Apple Blossom']
all_state_info['California'] = ['Sacramento', 39_461_600, 'California Poppy']
all_state_info['Colorado'] = ['Denver', 5_691_290, 'White and Lavender Columbine']
all_state_info['Connecticut'] = ['Hartford', 3_571_520, 'Mountain Laurel']
all_state_info['Delaware'] = ['Dover', 964_479, 'Peach Blossom']
all_state_info['Florida'] = ['Tallahassee', 21_244_300, 'Orange Blossom']
all_state_info['Georgia'] = ['Atlanta', 10_511_100, 'Cherokee Rose']
all_state_info['Hawaii'] = ['Honolulu', 1_420_590, 'Lokelani']
all_state_info['Idaho'] = ['Boise', 1_750_540, 'Syringa']
all_state_info['Illinois'] = ['Springfield', 12_723_100, 'Purple Violet']
all_state_info['Indiana'] = ['Indianapolis', 6_695_500, 'Peony']
all_state_info['Iowa'] = ['Des Moines', 3_148_620, 'Wild Prairie Rose']
all_state_info['Kansas'] = ['Topeka', 2_911_360, 'Sunflower']
all_state_info['Kentucky'] = ['Frankfort', 4_461_150, 'Goldenrod']
all_state_info['Louisiana'] = ['Baton Rouge', 4_659_690, 'Magnolia']
all_state_info['Maine'] = ['Augusta', 1_339_060, 'White Pine Cone and Tassel']
all_state_info['Maryland'] = ['Annapolis', 6_035_800, 'Black-Eyed Susan']
all_state_info['Massachusetts'] = ['Boston', 6_882_640, 'Mayflower']
all_state_info['Michigan'] = ['Lansing', 9_984_070, 'Apple Blossom']
all_state_info['Minnesota'] = ['Saint Paul', 5_606_250, 'Pink and White Lady Slipper']
all_state_info['Mississippi'] = ['Jackson', 2_981_020, 'Coreopsis']
all_state_info['Missouri'] = ['Jefferson City', 6_121_620, 'White Hawthorn Blossom']
all_state_info['Montana'] = ['Helena', 1_060_660, 'Bitterroot']
all_state_info['Nebraska'] = ['Lincoln', 1_925_610, 'Goldenrod']
all_state_info['Nevada'] = ['Carson City', 3_027_340, 'Sagebrush']
all_state_info['New Hampshire'] = ['Concord', 1_353_460, 'Purple Lilac']
all_state_info['New Jersey'] = ['Trenton', 8_886_020, 'Violet']
all_state_info['New Mexico'] = ['Santa Fe', 2_092_740, 'Yucca Flower']
all_state_info['New York'] = ['Albany', 19_530_400, 'Rose']
all_state_info['North Carolina'] = ['Raleigh', 10_381_600, 'Dogwood']
all_state_info['Ohio'] = ['Columbus', 11_676_300, 'Red Carnation']
all_state_info['Oklahoma'] = ['Oklahoma City', 3_940_240, 'Mistletoe']
all_state_info['Oregon'] = ['Salem', 4_181_890, 'Oregon Grape']
all_state_info['Pennsylvania'] = ['Harrisburg', 12_800_900, 'Mountain Laurel']
all_state_info['Rhode Island'] = ['Providence', 1_058_290, 'Violet']
all_state_info['South Carolina'] = ['Columbia', 5_084_160, 'Yellow Jessamine']
all_state_info['North Dakota'] = ['Bismarck', 758_080, 'Wild Prairie Rose']
all_state_info['South Dakota'] = ['Pierre', 878_698, 'Pasque Flower']
all_state_info['Tennessee'] = ['Nashville', 6_771_630, 'Iris']
all_state_info['Texas'] = ['Austin', 28_628_700, 'Bluebonnet']
all_state_info['Utah'] = ['Salt Lake City', 3_153_550, 'Sego Lily']
all_state_info['Vermont'] = ['Montpelier', 624_358, 'Red Clover']
all_state_info['Virginia'] = ['Richmond', 8_501_290, 'American Dogwood']
all_state_info['Washington'] = ['Olympia', 7_523_870, 'Pink Rhododendron']
all_state_info['West Virginia'] = ['Charleston', 1_804_290, 'Rhododendron']
all_state_info['Wisconsin'] = ['Madison', 5_807_410, 'Wood Violet']
all_state_info['Wyoming'] = ['Cheyenne', 577_601, 'Indian Paintbrush']

print('***Welcome to the State Information Program.***')
print(all_state_info['Alabama'][0])
# Main while loop to keep program running until user exits
while True:
    # while loop repeat choices until user makes valid selection or exits
    while True:
        try:
            usr_choice = int(input('\nPlease choose from the following selection:\n'
            '1.) Display all U.S. States in Alphabetical order '
            'along with the Capital, State Population, \nand Flower\n'
            '2.) Search for a specific state and display the appropriate Capital '
            'name, State Population, \nand an image of the associated State Flower.\n'
            '3.) Provide a Bar graph of the top 5 populated States showing their '
            'overall population.\n''4.) Update the overall state population '
            'for a specific state.\n''5.) Exit the program\n'))
        except ValueError:
            print('---Please enter the integer representing the choice you want.---')
            continue

        # Alphabetical order, all info
        if usr_choice == 1:
            abc_population()

        # State Search
        if usr_choice == 2:
            print('***State search with states flower image***')
            while True:
                try:
                    flower_image()
                    break
                except KeyError:
                    print('---State name entered was not found, '
                        'please check: spacing and spelling.---')
                    continue

        # Top 5 population bar graph
        if usr_choice == 3:
            print('***Top 5 state populations bar graph***')
            top_population_states()

        # Update state population
        if usr_choice == 4:
            print('***Update state overall population***')
            while True:
                try:
                    pop_update()
                    break
                except ValueError:
                    print('---New population was not accepted, please enter '
                        'an integer with underscores or no seperators.---')
                    continue
                except KeyError:
                    print('---State name entered was not found, '
                        'please check spacing and spelling.---')
                    continue

        # Exit program
        if usr_choice == 5:
            print(usr_choice)
            print('Thanks for using the state information program.')
            sys.exit()
