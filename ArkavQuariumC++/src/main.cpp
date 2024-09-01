#include "Ikan.hpp"
#include "List.hpp"
#include "Point.hpp"
#include "ObjekMati.hpp"
#include "FishFood.hpp"
#include "Coin.hpp"
#include "Aquarium.hpp"
#include "Objek.hpp"
#include "Piranha.hpp"
#include "oop.hpp"
#include "submarine.hpp"
#include <iostream>
#include <math.h>
#include <sstream>
#include <stdlib.h>
#include "Point.hpp"
#include "List.hpp"


const double speed = 200; // pixels per second


int main( int argc, char* args[] )
{
    init();

    //Arrah ikan
    char direction = 'R';

    // Menghitung FPS
    int frames_passed = 0;
    double fpc_start = time_since_start();
    std::string fps_text = "FPS: 0";

    // Posisi ikan
    double cy = SCREEN_HEIGHT / 2;
    double cx = SCREEN_WIDTH / 2;

    bool running = true;
    
    double prevtime = time_since_start();

    Aquarium Aq(600,500);
    Guppy GG(Point(210,210));
    Guppy G;
    Piranha P(Point(300,300));
    bool menu_on = true;
    int menu_state = 2;
    while(menu_on){
        clear_screen();
        if (menu_state == 2){
            draw_image("menu/menu_normal.jpg",SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        }
        else if (menu_state == 1){
            draw_image("menu/menu_play.jpg",SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        }
        else {
            draw_image("menu/menu_quit.jpg",SCREEN_WIDTH/2, SCREEN_HEIGHT/2);
        }
        handle_input();
        for (auto key :get_pressed_keys()){
            switch(key){
            case SDLK_UP :
                menu_state = !menu_state;
                break;
            case SDLK_DOWN :
                menu_state = !menu_state;
                break;
            case SDLK_SPACE :
                running = menu_state;
                menu_on =false;
                break;
            }
        }
        update_screen();
    }

    bool win;
    // FishFood::setFoodLvl(1);
    while (running) {
        double now = time_since_start();
        double sec_since_last = now - prevtime;
        prevtime = now;

        handle_input();
        if (quit_pressed()) {
            running = false;
        }
        // Gerakkan ikan selama tombol panah ditekan
        // Kecepatan dikalikan dengan perbedaan waktu supaya kecepatan ikan
        // konstan pada komputer yang berbeda.


        for (auto key : get_pressed_keys()) {
            cx = Aq.Sb.getPoint().getX();
            cy = Aq.Sb.getPoint().getY();
            switch (key) {
            case SDLK_UP:
                if(cy < 60){
                    break;
                }
                else{
                    Aq.Sb.move(0,-1);
                    break;
                }
            case SDLK_DOWN:
                if(cy > SCREEN_HEIGHT - 100){
                    break;
                }
                else{
                    Aq.Sb.move(0,1);
                    break;
                }
            case SDLK_LEFT:
                direction = 'L';
                if(cx < 40){
                    break;
                }
                else{
                    
                    Aq.Sb.move(-1,0);
                    break;
                }
                
            case SDLK_RIGHT:
                direction = 'R';
                if(cx > SCREEN_WIDTH- 40){
                    break;
                }
                else{
                    Aq.Sb.move(1,0);
                    break;
                }
                direction = 'R';
               
            }
        }
        
        int mouse_x;
        int mouse_y;
        SDL_Event event;
        while(SDL_PollEvent(&event)){
            if (event.type == SDL_MOUSEMOTION){
                /* If the mouse is moving to the left */
                if (event.motion.xrel < 0){
                    direction = 'L';
                if(cx < 40){
                    break;
                }
                else{
                    
                    Aq.Sb.move(-event.motion.x,0);
                    break;
                }   
                }
                /* If the mouse is moving to the right */
                else if (event.motion.xrel > 0){
                    direction = 'R';
                if(cx > SCREEN_WIDTH- 40){
                    break;
                }
                else{
                    Aq.Sb.move(event.motion.x,0);
                    break;
                }
                direction = 'R';
                }
                /* If the mouse is moving up */
                else if (event.motion.yrel < 0){
                    if(cy > SCREEN_HEIGHT - 100){
                        break;
                    }
                    else{
                        Aq.Sb.move(0,-event.motion.y);
                        break;
                    }
                }
                /* If the mouse is moving down */
                else if (event.motion.yrel > 0){
                    if(cy > SCREEN_HEIGHT - 100){
                    break;
                }
                else{
                    Aq.Sb.move(0,event.motion.y);
                    break;
                }
                }
            }
        }

        // Proses masukan yang bersifat "tombol"
        for (auto key : get_tapped_keys()) {
            switch (key) {
            // r untuk reset
            case SDLK_r:
                cy = SCREEN_HEIGHT / 2;
                cx = SCREEN_WIDTH / 2;
                break;
            // x untuk keluar
            case SDLK_x:
                running = false;
                break;
            // case SDLK_u:
            //     if(Coin::getCollectedCoins() > Aq.getFoodUpPrice()){
            //         FishFood::incFoodLvl();
            //         Coin::decCollectedCoin(Aq.getFoodUpPrice());
            //     }
            //     break;
            case SDLK_m:
                if(Coin::getCollectedCoins() > Aq.getCurrFoodPrice()){
                    FishFood(Point(cx,cy));
                    Coin::decCollectedCoin(Aq.getCurrFoodPrice());
                }
                break;
            case SDLK_g :
                if(Coin::getCollectedCoins() > Ikan::getDefaultPrice()){
                    double randX = rand()%(SCREEN_WIDTH -200);
                    double randY = rand()%(SCREEN_HEIGHT-200);
                    Guppy(Point( randX+100,randY+100));
                    Coin::decCollectedCoin(Ikan::getDefaultPrice());
                }
                break;
            case SDLK_p :
                if(Coin::getCollectedCoins() > Piranha::getDefaultPrice()){
                    double randX = rand()%(SCREEN_WIDTH -200);
                    double randY = rand()%(SCREEN_HEIGHT-200);
                    Piranha(Point(randX+100,randY+100));
                    Coin::decCollectedCoin(Piranha::getDefaultPrice());
                }
                break;
            case SDLK_e :
                if(Coin::getCollectedCoins() > Aq.getCurrEggPrice()){
                    Coin::decCollectedCoin(Aq.getCurrEggPrice());
                    Aq.increaseEggState();
                }
                break;
            case SDLK_b :
                break;
            }
                

        }
        // Update FPS setiap detik
        frames_passed++;
        if (now - fpc_start > 1) {
            std::ostringstream strs;
            strs << "FPS: " ;
            strs << frames_passed/(now - fpc_start);
            fps_text = strs.str();;
            fpc_start = now;
            frames_passed = 0;
        }

        // Gambar ikan di posisi yang tepat.
        clear_screen();
        // draw_image("juubi.png", 320,240);
        draw_image("aquarium/aquarium.jpg",320,240);
        draw_text("Panah:bergerak - r:reset - x:keluar - e:beli telur - g:beli guppy - p:beli piranha - m:beli makanan", 13, 10, 10, 0, 0, 0);
        std::string S = "Jumlah Koin : ";
        S.append(std::to_string(Coin::getCollectedCoins()));
        draw_text(S,16, 10, 30, 0, 0, 0);
        // draw_text(fps_text, 18, 10, 20, 0, 0, 0);
        std::string S1 = "Jumlah Telur = ";
        S1.append(std::to_string(Aq.getEggState()));
        S1.append("/3 | Harga telur berikutnya = ");
        S1.append(std::to_string(Aq.getCurrEggPrice()));
        draw_text(S1, 16, 10, 50, 0, 0, 0);
        Guppy::getGuppyList().drawAll();
        Piranha::getListPiranha().drawAll();
        FishFood::getFoodList().drawAll();
        Coin::getActiveCoins().drawAll();
        Aq.Snaily.draw();
        draw_image("cursor/starfish_16.png",cx,cy);
        Aq.Sb.draw();
        update_screen();
        Coin::getActiveCoins().drownAll();
        FishFood::getFoodList().drownAll();
        Guppy::getGuppyList().moveAll();
        Piranha::getListPiranha().moveAll();
        Aq.Sb.move(0,0);
        Aq.Snaily.move();


        if (Aq.getEggState() == 3) {
            win = true;
            running = false;
        } else if (Guppy::getGuppyList().isEmpty() && Piranha::getListPiranha().isEmpty() && Coin::getCollectedCoins() < 100) {
            win = false;
            running = false;
        }
        
        // sleep(20);

    }
    if (menu_state){
        for(int i = 0;i < 1000; i++){
            clear_screen();
            if(win) draw_image("end_game/win.jpg",SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
            else draw_image("end_game/lose.jpg", SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
            update_screen();
        }
    }

    close();

    return 0;
} 
