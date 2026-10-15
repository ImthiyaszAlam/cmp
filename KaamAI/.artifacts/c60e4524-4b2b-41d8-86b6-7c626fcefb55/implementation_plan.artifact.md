# Implementation Plan - KaamAI App Architecture & Bottom Navigation (Home & Report)

Build the KaamAI Compose Multiplatform (CMP) app following clean architecture, proper separation of concerns, and a standard CMP folder structure, featuring a bottom navigation bar with exactly two tabs: **Home** and **Report**.

## User Review Required

> [!IMPORTANT]
> This plan establishes a clean multiplatform folder structure (`ui`, `domain`, `data`, `navigation`) and implements the two-tab bottom bar (`Home` and `Report`) using Compose Multiplatform Material 3.

## Open Questions

- None at this stage. The requirements are clear: 2 bottom bar navs (Home and Report), separation of concerns, and proper CMP folder structure.

## Proposed Changes

### [shared] CMP Folder Structure & Clean Architecture

We will organize `commonMain/kotlin/com/imthiyas/kaamai/` into well-defined packages adhering to separation of concerns:
- `ui/theme/`: Material 3 Theme (`Theme.kt`, `Color.kt`, etc.)
- `ui/navigation/`: Navigation destinations and bottom navigation bar (`Screen.kt`, `NavGraph.kt`)
- `ui/home/`: Home Screen composable and state management (`HomeScreen.kt`, `HomeViewModel.kt`)
- `ui/report/`: Report Screen composable and state management (`ReportScreen.kt`, `ReportViewModel.kt`)
- `ui/main/`: Main layout with Bottom Navigation Scaffold (`MainScreen.kt`)
- `domain/`: Domain models and use cases
- `data/`: Local/remote data sources and repository implementations

#### [NEW] [Directory Structure](file:///C:/Users/Jaspreet/Desktop/cmp/KaamAI/shared/src/commonMain/kotlin/com/imthiyas/kaamai)
- `ui/theme/Theme.kt`
- `ui/navigation/Screen.kt`
- `ui/home/HomeScreen.kt`
- `ui/report/ReportScreen.kt`
- `ui/main/MainScreen.kt`
- `domain/model/`
- `data/repository/`

#### [MODIFY] [App.kt](file:///C:/Users/Jaspreet/Desktop/cmp/KaamAI/shared/src/commonMain/kotlin/com/imthiyas/kaamai/App.kt)
- Update `App()` entry point to host `MainScreen` within `MaterialTheme`.

## Verification Plan

### Automated Tests
- Run existing shared common tests via Gradle build/test tasks.
- Verify compilation across targets (Android, Desktop).

### Manual Verification
- Run the app on Android / Desktop and verify that:
  1. Bottom navigation bar shows exactly two tabs: **Home** and **Report**.
  2. Tapping **Home** switches to the Home screen.
  3. Tapping **Report** switches to the Report screen.
  4. Folder structure and separation of concerns are cleanly structured.
