# Airtable Timeline Assignment

## Overview

A modern Android timeline application built with Kotlin, Jetpack Compose, and MVVM architecture. The app provides an intuitive horizontal timeline view for managing and visualizing events with full CRUD functionality.

## Implementation Time

Approximately 4 hours

## What I Like About My Implementation

- **Clean Architecture**: The implementation follows MVVM pattern with clear separation of concerns between UI, business logic, and data layers
- **Feature-Based Structure**: Well-organized folder structure with clear separation of timeline and event management features
- **Efficient Layout Algorithm**: The timeline layout engine efficiently arranges events in compact swimlanes, minimizing vertical space usage
- **Horizontal Timeline**: Implements a horizontal scrolling timeline that provides better space utilization and navigation
- **Event Management**: Full CRUD functionality for events with form validation and type categorization
- **Responsive Design**: The timeline automatically adjusts to different screen sizes and event configurations
- **Self-Documenting Code**: Components are named and structured to clearly express their responsibilities without excessive comments
- **Material Design 3**: Uses modern Material Design components for a polished, professional appearance
- **Performance**: Leverages Compose's efficient rendering and state management
- **Synchronized Scrolling**: Timeline scale and events scroll together for intuitive navigation

## What I Would Change If I Were Going to Do It Again

- **Enhanced Interactivity**: Add drag-and-drop functionality for event editing and timeline navigation
- **Zoom Functionality**: Implement timeline zooming for better navigation of long timelines
- **Event Details**: Add click-to-expand functionality for viewing detailed event information
- **Event Filtering**: Implement filtering and search capabilities for large numbers of events
- **Responsive Layout**: Improve the layout for different screen orientations and sizes
- **Data Persistence**: Add local database storage for events
- **Event Categories**: Implement more sophisticated event categorization and filtering

## Design Decisions

- **Horizontal Timeline**: Chose horizontal layout for better space utilization and intuitive time navigation
- **Swimlane Algorithm**: I designed a custom algorithm that sorts events by start date and assigns them to the first available lane, ensuring optimal space utilization
- **Proportional Sizing**: Event widths are proportional to their duration, making it easy to visually compare event lengths
- **Lane Management**: Events that don't overlap can share lanes, reducing vertical space requirements
- **Event Types**: Implemented color-coded event types (Project, Meeting, Task) for better visual organization
- **Material Design**: Chose Material Design 3 for consistency with modern Android apps and accessibility
- **Compose Architecture**: Used Compose for declarative UI with clear state management through ViewModel
- **Custom Layout Engine**: Avoided external timeline libraries to demonstrate custom implementation skills
- **Feature-Based Organization**: Organized code by features (timeline, event) rather than by technical layers

## Testing Strategy

If I had more time, I would implement:

- **Unit Tests**: Test the timeline layout algorithm with various event configurations
- **UI Tests**: Test the timeline rendering, event positioning, and form interactions
- **Integration Tests**: Test the complete flow from data to UI rendering and event management
- **Performance Tests**: Test with large numbers of events to ensure scalability
- **Accessibility Tests**: Ensure the timeline is usable with screen readers and other assistive technologies
- **Form Validation Tests**: Test event form validation and error handling

## Build and Run Instructions

1. **Prerequisites**: Android Studio Hedgehog or later, JDK 17
2. **Clone the repository**: `git clone <repository-url>`
3. **Open in Android Studio**: Open the project in Android Studio
4. **Sync Gradle**: Wait for Gradle sync to complete
5. **Run on device/emulator**: Click the Run button or use `./gradlew installDebug`

## Project Structure

```
app/src/main/java/com/airtable/interview/airtableschedule/
├── MainActivity.kt                 # Main activity with navigation logic
├── domain/
│   ├── models/
│   │   ├── Event.kt               # Event data model with type categorization
│   │   ├── EventType.kt           # Event type enum (Project, Meeting, Task)
│   │   └── TimelineEvent.kt       # Timeline event with layout information
│   ├── repositories/
│   │   └── EventDataRepository.kt # Data access interface
│   └── usecases/
│       └── TimelineLayoutUseCase.kt # Custom timeline layout algorithm
├── data/
│   ├── repositories/
│   │   └── EventDataRepositoryImpl.kt # Repository implementation
│   └── sources/
│       └── SampleTimelineItems.kt # Sample data for testing
├── presentation/
│   ├── timeline/
│   │   ├── TimelineScreen.kt      # Main timeline screen with FAB
│   │   ├── TimelineViewModel.kt   # Timeline state management
│   │   └── TimelineUiState.kt     # Timeline UI state
│   └── event/
│       ├── EventFormScreen.kt     # Event form screen
│       ├── EventFormViewModel.kt  # Event form state management
│       └── EventFormUiState.kt    # Event form UI state
└── ui/
    ├── timeline/
    │   ├── TimelineView.kt        # Main timeline view component
    │   └── composable/
    │       ├── TimelineHeader.kt  # Timeline header component
    │       ├── TimelineScale.kt   # Timeline date scale
    │       ├── TimelineEventBlock.kt # Individual event blocks
    │       └── TimelineGridBackground.kt # Timeline grid background
    └── event/
        └── composable/
            └── EventFormContent.kt # Event form content components
```

## Key Features Implemented

- **Multi-lane Timeline**: Events are arranged in compact swimlanes with horizontal scrolling
- **Proportional Event Sizing**: Event width corresponds to duration for visual comparison
- **Efficient Space Usage**: Non-overlapping events share lanes, reducing space requirements
- **Event Management**: Full CRUD functionality for creating, editing, and deleting events
- **Event Types**: Color-coded event categorization (Project, Meeting, Task)
- **Form Validation**: Comprehensive form validation with error messages
- **Toast Notifications**: Success feedback when events are saved or updated
- **Real-time Updates**: Timeline immediately refreshes when events are modified
- **Form State Management**: Proper form clearing between add/edit modes
- **Horizontal Navigation**: Intuitive horizontal scrolling through timeline
- **Synchronized Scrolling**: Timeline scale and events scroll together
- **Responsive Layout**: Adapts to different screen sizes and orientations
- **Clean UI**: Modern Material Design 3 interface with floating action button
- **State Management**: Proper MVVM architecture with ViewModel and StateFlow

## Technical Highlights

- **Custom Layout Algorithm**: Implemented from scratch without external timeline libraries
- **Compose UI**: Modern declarative UI framework with proper component separation
- **MVVM Architecture**: Clean separation of concerns with proper data flow
- **Kotlin Coroutines**: Asynchronous data handling with Flow and StateFlow
- **Material Design 3**: Latest design system components and theming
- **Feature-Based Organization**: Well-structured codebase organized by features
- **Form Handling**: Robust form state management with validation
- **Navigation**: Simple but effective screen navigation without external navigation libraries
