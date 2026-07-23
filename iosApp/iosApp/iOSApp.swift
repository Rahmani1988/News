import SwiftUI
import SharedLogic

@main
struct iOSApp: App {

    init() {
         SharedLogic.KoinHelperKt.doInitKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}